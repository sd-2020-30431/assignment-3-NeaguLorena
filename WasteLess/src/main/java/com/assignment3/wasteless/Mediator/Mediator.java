package com.assignment3.wasteless.Mediator;

import com.assignment3.wasteless.Mediator.Handlers.*;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListCommand;
import com.assignment3.wasteless.Mediator.Requst.Command.CreateGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Requst.Command.DeleteGroceryListItemCommand;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListItemsQuery;
import com.assignment3.wasteless.Mediator.Requst.Query.GetGroceryListsQuery;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Mediator implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<Class<? extends Request>, Class<? extends Handler<? extends Request, ? extends Response>>> mapRequestToHandler;

    public Mediator() {
        this.mapRequestToHandler = new HashMap<>();
        initializeMapRequestToHandler();
    }

    public void initializeMapRequestToHandler() {
        mapRequestToHandler.put(CreateGroceryListCommand.class, CreateGroceryListCommandHandler.class);
        mapRequestToHandler.put(GetGroceryListsQuery.class, GetGroceryListsQueryHandler.class);
        mapRequestToHandler.put(GetGroceryListItemsQuery.class, GetGroceryListItemsQueryHandler.class);
        mapRequestToHandler.put(CreateGroceryListItemCommand.class, CreateGroceryListItemCommandHandler.class);
        mapRequestToHandler.put(DeleteGroceryListItemCommand.class, DeleteGroceryListItemCommandHandler.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <Rq extends Request, Rs extends Response> Handler<Rq, Rs> handleRequest(Rq request) {
        return (Handler<Rq, Rs>) applicationContext.getBean(mapRequestToHandler.get(request.getClass()));
    }
}
