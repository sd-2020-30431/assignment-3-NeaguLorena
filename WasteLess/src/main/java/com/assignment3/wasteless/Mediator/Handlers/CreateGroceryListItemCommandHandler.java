package com.assignment3.wasteless.Mediator.Handlers;

import com.assignment3.wasteless.Bussiness.Service.Command.GroceryListItemCommandService;
import com.assignment3.wasteless.Mediator.Handler;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Responses.CreateGroceryListItemCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateGroceryListItemCommandHandler implements Handler<CreateGroceryListItemCommand, CreateGroceryListItemCommandResponse> {

    private GroceryListItemCommandService groceryListItemCommandService;

    public CreateGroceryListItemCommandHandler(GroceryListItemCommandService groceryListItemCommandService) {
        this.groceryListItemCommandService = groceryListItemCommandService;
    }

    @Override
    public CreateGroceryListItemCommandResponse handleRequest(CreateGroceryListItemCommand request) {
        return new CreateGroceryListItemCommandResponse(groceryListItemCommandService.save(request.getGroceryListItem()));
    }
}
