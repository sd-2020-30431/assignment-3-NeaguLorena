package com.assignment3.wasteless.Bussiness.Service.Command;

import com.assignment3.wasteless.Data.Repository.GroceryListRepository;
import com.assignment3.wasteless.Presentation.Model.GroceryList;
import org.springframework.stereotype.Service;

@Service
public class GroceryListCommandService {

    private GroceryListRepository groceryListRepository;

    public GroceryListCommandService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public GroceryList save(GroceryList groceryList){
        return groceryListRepository.save(groceryList);
    }
}
