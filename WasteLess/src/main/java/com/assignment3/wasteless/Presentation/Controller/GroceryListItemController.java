package com.assignment3.wasteless.Presentation.Controller;

import com.assignment3.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment3.wasteless.Mediator.Handlers.CreateGroceryListItemCommandHandler;
import com.assignment3.wasteless.Mediator.Handlers.DeleteGroceryListItemCommandHandler;
import com.assignment3.wasteless.Mediator.Handlers.GetGroceryListItemsQueryHandler;
import com.assignment3.wasteless.Mediator.Mediator;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Requst.Command.DeleteGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListItemsQuery;
import com.assignment3.wasteless.Mediator.Responses.CreateGroceryListItemCommandResponse;
import com.assignment3.wasteless.Mediator.Responses.DeleteGroceryListItemResponse;
import com.assignment3.wasteless.Mediator.Responses.GetGroceryListItemsQueryResponse;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryListItemController {

    private final GroceryListItemRepository groceryListItemRepository;
    private Mediator mediator;

    public GroceryListItemController(Mediator mediator, GroceryListItemRepository groceryListItemRepository) {
        this.mediator = mediator;
        this.groceryListItemRepository = groceryListItemRepository;
    }

    @PostMapping("/groceryLists-user/{listId}")
    public GroceryListItem createGroceryListItem(@RequestBody GroceryListItem groceryListItem, @PathVariable int listId) {
        if (groceryListItem.getName() != null && groceryListItem.getExpirationDate() != null) {
            groceryListItem.setListId(listId);
            CreateGroceryListItemCommand request = new CreateGroceryListItemCommand(groceryListItem);
            CreateGroceryListItemCommandHandler handler = (CreateGroceryListItemCommandHandler)mediator.<CreateGroceryListItemCommand, CreateGroceryListItemCommandResponse>handleRequest(request);
            return handler.handleRequest(request).getGroceryListItem();
        }
        return null;
    }

    @GetMapping("/groceryLists-user/{listId}")
    public List<GroceryListItem> getAllGroceryListItemsByListId(@PathVariable int listId) {
        GetGroceryListItemsQuery request = new GetGroceryListItemsQuery(listId);
        GetGroceryListItemsQueryHandler handler = (GetGroceryListItemsQueryHandler) mediator.<GetGroceryListItemsQuery, GetGroceryListItemsQueryResponse>handleRequest(request);
        return handler.handleRequest(request).getGroceryListItems();
    }

    @DeleteMapping("/delete/{itemId}")
    public void deleteGroceryListItem(@PathVariable int itemId) {
        DeleteGroceryListItemCommand request = new DeleteGroceryListItemCommand(itemId);
        DeleteGroceryListItemCommandHandler handler = (DeleteGroceryListItemCommandHandler)mediator.<DeleteGroceryListItemCommand, DeleteGroceryListItemResponse> handleRequest(request);
        handler.handleRequest(request);
    }

    @PostMapping("/consume/{itemId}")
    public GroceryListItem consumeGroceryListItem(@PathVariable int itemId) {
        GroceryListItem oldGroceryListItem = groceryListItemRepository.findItemByItemId(itemId);
        oldGroceryListItem.setConsumptionDate(new Date());
        return groceryListItemRepository.save(oldGroceryListItem);
    }
}
