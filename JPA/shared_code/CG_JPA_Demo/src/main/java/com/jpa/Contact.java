package com.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="contact")
@NamedQueries({
	@NamedQuery(name = "READ_ALL_CONTACTS", query = "SELECT ct from Contact ct"),
	@NamedQuery(name = "READ_ALL_CONTACT_MOBILE", query = "SELECT ct.mobileNo from Contact ct")
})
public class Contact {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobile")
	private long mobileNo;
	
	public Contact(int id, String name, long mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public Contact(String name, long mobileNo) {
		super();
		this.name = name;
		this.mobileNo = mobileNo;
	}
	public Contact() {
		super();
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
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
