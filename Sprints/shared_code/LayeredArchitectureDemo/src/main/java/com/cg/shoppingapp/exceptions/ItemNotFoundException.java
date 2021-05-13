package com.cg.shoppingapp.exceptions;

public class ItemNotFoundException extends Exception {
	private String message;
	
	public ItemNotFoundException() {
		this.message = "";
	}
	public ItemNotFoundException(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Item not found " + this.message;
	}
}
