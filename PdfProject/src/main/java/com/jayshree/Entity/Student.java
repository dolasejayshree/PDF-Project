package com.jayshree.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Student_Data")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    @Column
	private String name;
    @Column
	private String surname;
    @Column
	private String address;
    @Column
	private Integer fees;
    
    
    
	public Student(String name, String surname, String address, Integer fees) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.fees = fees;
	}
	
	
	public Student() {
		super();
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getFees() {
		return fees;
	}
	public void setFees(Integer fees) {
		this.fees = fees;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + ", fees="
				+ fees + "]";
	}
    
    
    
    
}
