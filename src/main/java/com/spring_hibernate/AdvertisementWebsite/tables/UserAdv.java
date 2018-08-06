package com.spring_hibernate.AdvertisementWebsite.tables;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.transaction.annotation.Transactional;

import com.spring_hibernate.AdvertisementWebsite.entity.User;

@Entity
@Table(name="ADV_DETAILS")
public class UserAdv {

	@Id
	@GeneratedValue
	@Column(name="ad_id")
	private long id;
	
	@Column(name="ad_title")
	private String title;
	
	@Column(name="ad_cat")
	private String category;
	
	/*@Column(name="ad_uname")
	private String name;*/
	
	@Column(name="ad_desc")
	private String description;
	
	@ManyToOne(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;

	public UserAdv(){}
	public UserAdv(String title, String category,  String description,User user) {
		super();
		this.title = title;
		this.category = category;
		//this.name = name;
		this.description = description;
		this.user=user;
	}

	@Override
	public String toString() {
		return "UserAdv [id=" + id + ", title=" + title + ", category=" + category + ", name=" +  ", description="
				+ description + "]";
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

/*	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
