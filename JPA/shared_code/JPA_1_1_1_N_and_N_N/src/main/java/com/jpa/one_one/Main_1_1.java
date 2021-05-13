package com.jpa.one_one;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main_1_1 
{
    public static void main( String[] args )
    {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("EntityRelationshipPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Profile profile = new Profile("Microsoft", 5);
		entityManager.getTransaction().begin();
		Employee emp = new Employee("Tom", 20000, profile);
		entityManager.persist(emp);
		int e_id = emp.getEmployeeId(); //Managed
		System.out.println("Employee id = " + e_id);
		entityManager.getTransaction().commit();
		
		entityManager.getTransaction().begin();
		Employee emp2 = entityManager.find(Employee.class, e_id); // Managed
		emp2.setSal(35000);
		emp2.getProfile().setExperience(6);
		entityManager.getTransaction().commit();
		
		Query query = entityManager.createQuery("Select emp from Employee emp"); //JPQL
		List<Employee> employees = query.getResultList();
		for(Employee e: employees) {
			System.out.println("employee = " + e);
		}
		
		entityManager.getTransaction().begin();
		Employee emp4 = entityManager.find(Employee.class, e_id);
		entityManager.remove(emp4);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
    }
}
