package com.jpa.many_many;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main_N_N 
{
	private static EntityManager entityManager;
	
	public static void insertCourses() {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("EntityRelationshipPU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Student student_tom = new Student("Tom"); //Java, Hibernate
		Student student_jerry = new Student("Jerry"); //Java, Spring
		Student student_ivan = new Student("Ivan"); //Hibernate, Spring
		
		Set<Student> java_students = new HashSet<Student>();
		java_students.add(student_tom);java_students.add(student_jerry);
		Set<Student> hibernate_students = new HashSet<Student>();
		hibernate_students.add(student_tom);hibernate_students.add(student_ivan);
		Set<Student> spring_students = new HashSet<Student>();
		spring_students.add(student_jerry);spring_students.add(student_ivan);
		
		Course course_java = new Course("Java programming", java_students);		
		Course course_hibernate = new Course("Hibernate", hibernate_students);
		Course course_spring = new Course("Spring", spring_students);

		entityManager.getTransaction().begin();
		entityManager.persist(course_java);
		entityManager.persist(course_hibernate);
		entityManager.persist(course_spring);
		entityManager.getTransaction().commit();
	}
	
	public static void insertStudents() {
		Course course_1 = new Course("Java programming");		
		Course course_2 = new Course("Hibernate");
		Course course_3 = new Course("Spring");
		Set<Course> tomCourses = new HashSet<Course>();
		Set<Course> jerryCourses = new HashSet<Course>();
		tomCourses.add(course_1);tomCourses.add(course_2);tomCourses.add(course_3);
		jerryCourses.add(course_1);jerryCourses.add(course_3);
		Student student_tom = new Student("Tom", tomCourses);
		Student student_jerry = new Student("Jerry", jerryCourses);

		entityManager.getTransaction().begin();
		entityManager.persist(student_tom);
		entityManager.persist(student_jerry);
		entityManager.getTransaction().commit();
	}
    public static void main( String[] args )
    {
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("EntityRelationshipPU");
		entityManager = entityManagerFactory.createEntityManager();
		
		//insertStudents();
		insertCourses();
		
		Query query = entityManager.createQuery("select courses from Course courses where courses.courseId=:courseId");
		query.setParameter("courseId", 2);
		List<Course> courses = query.getResultList();
		System.out.println("courses: " + courses);
		entityManagerFactory.close();
    }
}
