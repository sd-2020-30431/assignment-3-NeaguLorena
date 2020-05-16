package com.assignment3.wasteless.Bussiness.Service.Query;

import com.assignment3.wasteless.Data.Repository.GroceryListItemRepository;
import com.assignment3.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListItemQueryService {

    private GroceryListItemRepository groceryListItemRepository;

    public GroceryListItemQueryService(GroceryListItemRepository groceryListItemRepository) {
        this.groceryListItemRepository = groceryListItemRepository;
    }

    public List<GroceryListItem> findAllByListId(int listId) {
        return groceryListItemRepository.findAllByListId(listId);
    }

    public GroceryListItem findItemByItemId(int itemId) {
        return groceryListItemRepository.findItemByItemId(itemId);
    }
}
