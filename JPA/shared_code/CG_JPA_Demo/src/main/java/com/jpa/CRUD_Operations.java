package com.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CRUD_Operations {

	private static EntityManager entityManager;
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ShopCartAppPU");
		entityManager = entityManagerFactory.createEntityManager();
		
		//insertContact();
		//updateContact();
		//deleteContact();
		readAllContacts();
	}

	public static void readAllContacts() {
		//Query query = entityManager.createQuery("SELECT ct from Contact ct");//JPQL
		Query query = entityManager.createNamedQuery("READ_ALL_CONTACTS");
		List<Contact> contactList = query.getResultList();//Fire JPQL query
		for(Contact contact: contactList) {
			System.out.println(contact);
		}
	}
	
	public static void deleteContact() {
		entityManager.getTransaction().begin();
		Contact contactObj = entityManager.find(Contact.class, 13);
		entityManager.remove(contactObj);
		entityManager.getTransaction().commit();
		System.out.println("Contact deleted succssfully!!");
	}

	public static void insertContact() {
		Contact contactObj = new Contact("Jerry", 76486548);
		entityManager.getTransaction().begin();
		entityManager.persist(contactObj);
		entityManager.getTransaction().commit();
		System.out.println("Contact inserted succssfully!!");
	}

	public static void updateContact() {
		entityManager.getTransaction().begin();
		Contact contactObj = entityManager.find(Contact.class, 13);
		contactObj.setMobileNo(88888);
		entityManager.getTransaction().commit();
		System.out.println("Contact updated succssfully!!");
	}
}
