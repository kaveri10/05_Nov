package com.cg.shoppingapp.dao;

import com.cg.shoppingapp.entity.ItemEntity;
import com.cg.shoppingapp.exceptions.ItemNotFoundException;

public interface ItemDAO {
	ItemEntity findById(int itemId) throws ItemNotFoundException;
}
