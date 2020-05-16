package com.assignment3.wasteless.Mediator.Requst.Command;

import com.assignment3.wasteless.Mediator.Request;
import com.assignment3.wasteless.Presentation.Model.GroceryList;

public class CreateGroceryListCommand implements Request {

    private GroceryList groceryList;

    public CreateGroceryListCommand(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
