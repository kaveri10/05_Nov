package com.cg.shoppingapp.service;

import com.cg.shoppingapp.dto.Item;
import com.cg.shoppingapp.exceptions.ItemNotFoundException;

public interface ItemService {
	Item findById(int itemId) throws ItemNotFoundException;
}
