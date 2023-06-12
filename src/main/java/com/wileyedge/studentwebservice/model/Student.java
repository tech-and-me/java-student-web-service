package com.wileyedge.studentwebservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "studenttbl")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
	@SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", initialValue = 1, allocationSize = 1)
	private int stuid;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Column
	private String mob;
	
	@Column
	private String addr;
	
	public Student() {}
	
	public Student(String name, int age, String mob) {
		super();
		this.name = name;
		this.age = age;
		this.mob = mob;
	}

	public Student(String name, int age, String mob, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.mob = mob;
		this.addr = addr;
	}

	public Student(int stuid, String name, int age, String mob, String addr) {
		super();
		this.stuid = stuid;
		this.name = name;
		this.age = age;
		this.mob = mob;
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	
	public int getStuid() {
		return stuid;
	}
	
	
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", name=" + name + ", age=" + age + ", mob=" + mob + ", addr=" + addr + "]";
	}

	
	
}
