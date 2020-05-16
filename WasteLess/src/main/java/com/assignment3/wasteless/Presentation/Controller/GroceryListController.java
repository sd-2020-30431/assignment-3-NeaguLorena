package com.assignment3.wasteless.Presentation.Controller;

import com.assignment3.wasteless.Bussiness.Service.Query.NotificationQueryService;
import com.assignment3.wasteless.Bussiness.Service.UserService;
import com.assignment3.wasteless.Mediator.Handlers.CreateGroceryListCommandHandler;
import com.assignment3.wasteless.Mediator.Handlers.GetGroceryListsQueryHandler;
import com.assignment3.wasteless.Mediator.Mediator;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListCommand;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListsQuery;
import com.assignment3.wasteless.Mediator.Responses.CreateGroceryListCommandResponse;
import com.assignment3.wasteless.Mediator.Responses.GetGroceryListsQueryResponse;
import com.assignment3.wasteless.Presentation.Model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class GroceryListController {

    private final NotificationQueryService notificationQueryService;
    private Mediator mediator;


    public GroceryListController(Mediator mediator, NotificationQueryService notificationQueryService) {
        this.mediator = mediator;
        this.notificationQueryService = notificationQueryService;
    }

    @PostMapping("/groceryLists-user")
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) {
        groceryList.setUsername(UserService.getLoggedUser().getUsername());
        CreateGroceryListCommand request = new CreateGroceryListCommand(groceryList);
        CreateGroceryListCommandHandler handler = (CreateGroceryListCommandHandler) mediator.<CreateGroceryListCommand, CreateGroceryListCommandResponse>handleRequest(request);
        return handler.handleRequest(request).getGroceryList();
    }

    @GetMapping("/groceryLists-user")
    public List<GroceryList> getAllGroceryLists() {
        GetGroceryListsQuery request = new GetGroceryListsQuery(UserService.getLoggedUser().getUsername());
        GetGroceryListsQueryHandler handler = (GetGroceryListsQueryHandler)
                mediator.<GetGroceryListsQuery, GetGroceryListsQueryResponse>handleRequest(request);
        return handler.handleRequest(request).getGroceryLists();
    }

    @GetMapping("/itemsToExpire")
    public List<GroceryListItem> getItemsAboutToExpire() {
        return notificationQueryService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());
    }

    @GetMapping("/notificationMessage")
    public String getExpirationNotification() {
        String expirationMessage;
        List<GroceryListItem> itemsToExpire = notificationQueryService.getItemsAboutToExpire(UserService.getLoggedUser().getUsername());

        Notification notification = new Notification();
        NotificationObserver notificationObserver = new NotificationObserver();

        notification.addPropertyChangeListener(notificationObserver);
        if (itemsToExpire.size() > 0) {
            expirationMessage = "Some items are about to expire tomorrow!";
        } else expirationMessage = "";
        notification.setExpirationMessage(expirationMessage);

        return notificationObserver.getExpirationMessage();
    }
}
