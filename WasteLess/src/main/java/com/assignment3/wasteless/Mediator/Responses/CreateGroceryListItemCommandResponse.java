package com.assignment3.wasteless.Mediator.Responses;

import com.assignment3.wasteless.Mediator.Response;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;

public class CreateGroceryListItemCommandResponse implements Response {

    private GroceryListItem groceryListItem;

    public CreateGroceryListItemCommandResponse(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }

    public GroceryListItem getGroceryListItem() {
        return groceryListItem;
    }

    public void setGroceryListItem(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }
}
