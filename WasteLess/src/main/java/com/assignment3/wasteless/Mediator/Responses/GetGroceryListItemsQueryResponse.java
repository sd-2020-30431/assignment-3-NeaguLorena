package com.assignment3.wasteless.Mediator.Responses;

import com.assignment3.wasteless.Mediator.Response;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;

import java.util.List;

public class GetGroceryListItemsQueryResponse implements Response {

    private List<GroceryListItem> groceryListItems;

    public GetGroceryListItemsQueryResponse(List<GroceryListItem> groceryListItems) {
        this.groceryListItems = groceryListItems;
    }

    public List<GroceryListItem> getGroceryListItems() {
        return groceryListItems;
    }

    public void setGroceryListItems(List<GroceryListItem> groceryListItems) {
        this.groceryListItems = groceryListItems;
    }
}
