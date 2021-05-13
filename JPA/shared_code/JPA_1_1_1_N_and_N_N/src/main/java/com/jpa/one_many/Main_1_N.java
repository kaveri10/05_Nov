package com.jpa.one_many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hibernate.Session;

public class Main_1_N 
{
    public static void main( String[] args )
    {

		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("EntityRelationshipPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
    	
		Question qus = new Question("Which are the europian countries?");
		Answer ans = new Answer("Sweden", qus);
		Answer ans2 = new Answer("France", qus);
		Answer ans3 = new Answer("Austria", qus);
		Set<Answer> answers = new HashSet<Answer>();
		answers.add(ans);answers.add(ans2);answers.add(ans3);
		qus.setAnswers(answers);
		entityManager.getTransaction().begin();
		entityManager.persist(qus);
		int q_id = qus.getQusId();
		System.out.println("Question id = " + q_id);
		entityManager.getTransaction().commit();
    	
				
		
		
		entityManager.getTransaction().begin();
		Question qus2 = entityManager.find(Question.class, q_id);
		qus2.setQusDesc("List down the european countries");
		entityManager.getTransaction().commit();
		
		Query query = entityManager.createQuery("Select qus from Question qus"); //JPQL
		List<Question> questions = query.getResultList();
		for(Question q: questions) {
			System.out.println("Question = " + q);
		}
		
		entityManager.getTransaction().begin();
		Question qus4 = entityManager.find(Question.class, q_id);
		entityManager.remove(qus4);
		entityManager.getTransaction().commit();
		
		entityManagerFactory.close();
    }
}
