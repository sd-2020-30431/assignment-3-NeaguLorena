package com.assignment3.wasteless.Mediator.Handlers;

import com.assignment3.wasteless.Bussiness.Service.Command.GroceryListItemCommandService;
import com.assignment3.wasteless.Mediator.Handler;
import com.assignment3.wasteless.Mediator.Requst.Command.DeleteGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Responses.DeleteGroceryListItemResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteGroceryListItemCommandHandler implements Handler<DeleteGroceryListItemCommand, DeleteGroceryListItemResponse> {

    private GroceryListItemCommandService groceryListItemCommandService;

    @Override
    public DeleteGroceryListItemResponse handleRequest(DeleteGroceryListItemCommand request) {
        groceryListItemCommandService.deleteById(request.getItemId());
        return new DeleteGroceryListItemResponse();
    }
}
