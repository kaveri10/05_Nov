package com.cg.shoppingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item")
public class ItemEntity {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	public ItemEntity(int id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public ItemEntity(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public ItemEntity() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
