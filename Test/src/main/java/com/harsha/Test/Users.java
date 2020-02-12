package com.harsha.Test;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class Users {
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	int id;
	String name;
	int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
