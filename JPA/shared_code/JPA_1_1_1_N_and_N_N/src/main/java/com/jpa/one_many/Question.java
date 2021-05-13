package com.jpa.one_many;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question_bank")
public class Question {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int qusId;
	
	@Column(name="description")
	private String qusDesc;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, 
			fetch=FetchType.LAZY, mappedBy = "question")
	private Set<Answer> answers;
	
	public Question() {}
	
	public Question(String qusDesc) {
		this.qusDesc = qusDesc;
	}
	public Question(String qusDesc, Set<Answer> answers) {
		this.qusDesc = qusDesc;
		this.answers = answers;
	}

	public int getQusId() {
		return qusId;
	}

	public void setQusId(int qusId) {
		this.qusId = qusId;
	}

	public String getQusDesc() {
		return qusDesc;
	}

	public void setQusDesc(String qusDesc) {
		this.qusDesc = qusDesc;
	}

	public Set<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	public String toString() {
		return qusId + " - " + qusDesc + " - " + answers;
	}
}
