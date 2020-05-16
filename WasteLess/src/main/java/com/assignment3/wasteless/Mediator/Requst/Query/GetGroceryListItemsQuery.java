package com.assignment3.wasteless.Mediator.Requst.Query;

import com.assignment3.wasteless.Mediator.Request;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;

import java.util.List;

public class GetGroceryListItemsQuery implements Request {

    private int listId;

    public GetGroceryListItemsQuery(int listId) {
        this.listId = listId;
    }

    public int getListId() {
        return listId;
    }

    public void setListId(int listId) {
        this.listId = listId;
    }
}
