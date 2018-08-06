package com.spring_hibernate.AdvertisementWebsite.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORY")
public class Categories {

	@Id
	@GeneratedValue
	@Column(name="c_id")
	private int id;
	
	@Column(name="c_name")
	private String name;

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

	@Override
	public String toString() {
		return "Categories [id=" + id + ", name=" + name + "]";
	}

	public Categories(){}
	public Categories(String name) {
		super();
		this.name = name;
	}
	
	
}
