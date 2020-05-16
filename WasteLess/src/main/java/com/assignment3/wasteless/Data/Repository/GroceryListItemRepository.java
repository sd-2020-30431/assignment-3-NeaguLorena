package com.assignment3.wasteless.Data.Repository;

import com.assignment3.wasteless.Presentation.Model.GroceryListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroceryListItemRepository extends JpaRepository<GroceryListItem, Integer> {

    List<GroceryListItem> findAllByListId(int listId);

    GroceryListItem findItemByItemId(int itemId);

}
