package com.assignment3.wasteless.Mediator.Handlers;

import com.assignment3.wasteless.Bussiness.Service.Command.GroceryListCommandService;
import com.assignment3.wasteless.Bussiness.Service.Query.GroceryListQueryService;
import com.assignment3.wasteless.Mediator.Handler;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListsQuery;
import com.assignment3.wasteless.Mediator.Responses.GetGroceryListsQueryResponse;
import org.springframework.stereotype.Component;

@Component
public class GetGroceryListsQueryHandler implements Handler<GetGroceryListsQuery, GetGroceryListsQueryResponse> {

    private GroceryListQueryService groceryListQueryService;

    public GetGroceryListsQueryHandler(GroceryListQueryService groceryListQueryService) {
        this.groceryListQueryService = groceryListQueryService;
    }

    @Override
    public GetGroceryListsQueryResponse handleRequest(GetGroceryListsQuery request) {
        return new GetGroceryListsQueryResponse(groceryListQueryService.getAllByUsername(request.getusername()));

    }
}
