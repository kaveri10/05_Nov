package com.cg.shoppingapp.presentation;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.shoppingapp.exceptions.ItemNotFoundException;
import com.cg.shoppingapp.presentation.ShoppingAppController;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ShoppingAppControllerTest {

	private static ShoppingAppController shoppingAppController;
	private static Logger logger;
	
	@BeforeClass
	public static void setUp() {
		logger = LogManager.getLogger(ShoppingAppControllerTest.class.getName());
		shoppingAppController = new ShoppingAppController();
	}
	
	@Test
	public void testItemSearchSuccess() throws ItemNotFoundException {
		logger.info("[START] testItemSearchSuccess()");
		assertNotNull("Item Found", shoppingAppController.findItemById(1));
		logger.info("[END] testItemSearchSuccess()");
	}
	
	@Test(expected = ItemNotFoundException.class)
	public void testItemSearchFailed() throws ItemNotFoundException {
		logger.info("[START] testItemSearchFailed()");
		shoppingAppController.findItemById(-2);
		logger.info("[END] testItemSearchFailed()");
	}
}
