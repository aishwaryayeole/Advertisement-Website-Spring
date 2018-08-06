package com.spring_hibernate.AdvertisementWebsite.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SESSION_TABLE")
public class SessionTable {
	
	@GeneratedValue
	@Id
	@Column(name="s_id")
	private long id;
	
	@Column(name="s_name")
	private String name;
	
	@Column(name="s_date")
	private Date date;

	public SessionTable(){}
	public SessionTable(String name, Date date) {
		super();
		this.name = name;
		this.date = date;
	}

	@Override
	public String toString() {
		return "SessionTable [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
