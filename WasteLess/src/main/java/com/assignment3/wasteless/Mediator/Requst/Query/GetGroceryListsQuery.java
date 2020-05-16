package com.assignment3.wasteless.Mediator.Requst.Query;

import com.assignment3.wasteless.Mediator.Request;

public class GetGroceryListsQuery implements Request {

    private String username;

    public GetGroceryListsQuery(String username) {
        this.username = username;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }
}