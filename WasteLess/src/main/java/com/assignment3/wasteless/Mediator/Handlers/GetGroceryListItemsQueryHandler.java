package com.assignment3.wasteless.Mediator.Handlers;

import com.assignment3.wasteless.Bussiness.Service.Query.GroceryListItemQueryService;
import com.assignment3.wasteless.Mediator.Handler;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListItemsQuery;
import com.assignment3.wasteless.Mediator.Responses.GetGroceryListItemsQueryResponse;
import org.springframework.stereotype.Component;

@Component
public class GetGroceryListItemsQueryHandler implements Handler<GetGroceryListItemsQuery, GetGroceryListItemsQueryResponse> {

    private GroceryListItemQueryService groceryListItemQueryService;

    public GetGroceryListItemsQueryHandler(GroceryListItemQueryService groceryListItemQueryService) {
        this.groceryListItemQueryService = groceryListItemQueryService;
    }

    @Override
    public GetGroceryListItemsQueryResponse handleRequest(GetGroceryListItemsQuery request) {
        return new GetGroceryListItemsQueryResponse(groceryListItemQueryService.findAllByListId(request.getListId()));
    }
}
