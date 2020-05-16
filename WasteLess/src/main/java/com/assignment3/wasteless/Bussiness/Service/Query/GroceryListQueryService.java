package com.assignment3.wasteless.Bussiness.Service.Query;

import com.assignment3.wasteless.Data.Repository.GroceryListRepository;
import com.assignment3.wasteless.Presentation.Model.GroceryList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListQueryService {

    private GroceryListRepository groceryListRepository;

    public GroceryListQueryService(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }

    public List<GroceryList> getAllByUsername(String username){
        return groceryListRepository.getAllByUsername(username);
    }

}
