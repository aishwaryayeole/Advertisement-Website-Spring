package com.spring_hibernate.AdvertisementWebsite.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACTION")
public class Actions {
	
	public Actions(){}
	public Actions(String name) {
		super();
	
		this.name = name;
	}

	@Override
	public String toString() {
		return "Actions [id=" + id + ", name=" + name + "]";
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

	@Id
	@GeneratedValue
	@Column(name="a_id")
	private int id;
	
	@Column(name="a_name")
	private String name;

}
