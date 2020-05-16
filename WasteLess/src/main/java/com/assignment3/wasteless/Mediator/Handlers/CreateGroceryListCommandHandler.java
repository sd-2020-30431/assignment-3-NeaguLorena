package com.assignment3.wasteless.Mediator.Handlers;

import com.assignment3.wasteless.Bussiness.Service.Command.GroceryListCommandService;
import com.assignment3.wasteless.Mediator.Handler;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListCommand;
import com.assignment3.wasteless.Mediator.Responses.CreateGroceryListCommandResponse;
import org.springframework.stereotype.Component;

@Component
public class CreateGroceryListCommandHandler implements Handler<CreateGroceryListCommand, CreateGroceryListCommandResponse> {

    private GroceryListCommandService groceryListCommandService;

    public CreateGroceryListCommandHandler(GroceryListCommandService groceryListService) {
        this.groceryListCommandService = groceryListService;
    }

    @Override
    public CreateGroceryListCommandResponse handleRequest(CreateGroceryListCommand request) {
        return new CreateGroceryListCommandResponse(groceryListCommandService.save(request.getGroceryList()));
    }
}
