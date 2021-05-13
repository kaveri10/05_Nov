package com.jpa.one_one;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="profile")
public class Profile {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="company")
	private String company;
	
	@Column(name="experience")
	private double experience;
	
	public Profile() {
		
	}
	
	public Profile(String company, double experience) {
		this.company = company;
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getExperience() {
		return experience;
	}

	public void setExperience(double experience) {
		this.experience = experience;
	}

	public String toString() {
		return id + " - " + experience + " - " + company;
	}
	
}
