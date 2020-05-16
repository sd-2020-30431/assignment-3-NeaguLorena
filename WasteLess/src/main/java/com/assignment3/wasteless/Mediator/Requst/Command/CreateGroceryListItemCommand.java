package com.assignment3.wasteless.Mediator.Requst.Command;

import com.assignment3.wasteless.Mediator.Request;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;

public class CreateGroceryListItemCommand implements Request {

    private GroceryListItem groceryListItem;

    public CreateGroceryListItemCommand(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }

    public GroceryListItem getGroceryListItem() {
        return groceryListItem;
    }

    public void setGroceryListItem(GroceryListItem groceryListItem) {
        this.groceryListItem = groceryListItem;
    }

}
