package com.assignment3.wasteless.Mediator.Responses;

import com.assignment3.wasteless.Mediator.Response;
import com.assignment3.wasteless.Presentation.Model.GroceryList;

public class CreateGroceryListCommandResponse implements Response {

    private GroceryList groceryList;

    public CreateGroceryListCommandResponse(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }
}
