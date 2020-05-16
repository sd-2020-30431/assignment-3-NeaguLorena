package com.assignment3.wasteless.Mediator.Requst.Command;

import com.assignment3.wasteless.Mediator.Request;

public class DeleteGroceryListItemCommand implements Request {

    private int itemId;

    public DeleteGroceryListItemCommand(int itemId) {
        this.itemId = itemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
