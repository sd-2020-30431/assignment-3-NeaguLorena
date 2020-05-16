package com.assignment3.wasteless.Mediator.Responses;

import com.assignment3.wasteless.Mediator.Response;
import com.assignment3.wasteless.Presentation.Model.GroceryList;

import java.util.List;

public class GetGroceryListsQueryResponse implements Response {
    private List<GroceryList> groceryLists;

    public GetGroceryListsQueryResponse(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }

    public List<GroceryList> getGroceryLists() {
        return groceryLists;
    }

    public void setGroceryLists(List<GroceryList> groceryLists) {
        this.groceryLists = groceryLists;
    }
}
