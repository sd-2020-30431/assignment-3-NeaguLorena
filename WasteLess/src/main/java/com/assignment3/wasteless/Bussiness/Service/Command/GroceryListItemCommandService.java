package com.assignment3.wasteless.Bussiness.Service.Command;

import com.assignment3.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment3.wasteless.Data.Repository.GroceryListRepository;
import com.assignment3.wasteless.Presentation.Model.GroceryList;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListItemCommandService {

    private GroceryListItemRepository groceryListItemRepository;

    public GroceryListItemCommandService(GroceryListItemRepository groceryListItemRepository) {
        this.groceryListItemRepository = groceryListItemRepository;
    }

    public GroceryListItem save(GroceryListItem groceryListItem) {
        return groceryListItemRepository.save(groceryListItem);
    }

    public void deleteById(int listItemId) {
        groceryListItemRepository.deleteById(listItemId);
    }

}
