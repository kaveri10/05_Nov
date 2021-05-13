package com.cg.shoppingapp.utils;

import com.cg.shoppingapp.dto.Item;
import com.cg.shoppingapp.entity.ItemEntity;

public class ShoppingAppUtils {
	public static ItemEntity convertItemIntoItemEntity(Item item) {
		return new ItemEntity(item.getId(), item.getName(), item.getPrice());
	}
	public static Item convertItemEntityIntoItem(ItemEntity itemEntity) {
		return new Item(itemEntity.getId(), itemEntity.getName(), itemEntity.getPrice());
	}
}
