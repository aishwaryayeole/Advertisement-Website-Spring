package com.spring_hibernate.AdvertisementWebsite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;

/*@NamedQueries({
	@NamedQuery(
			name="findUser", 
			query="SELECT  firstName,lastName FROM User WHERE userName=:name "
			)
})*/
@Entity
@Table(name="USER_DETAILS")
public class User {

	public User(){}
	public User(String firstName, String lastName, String userName, String password, long phone,
			String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.email = email;
	}

	@GeneratedValue
	@Id
	@Column(name="u_id")
	private Long id;
	
	@Column(name="fname")
	private String firstName;
	
	@Column(name="lname")
	private String lastName;
	
	@Column(name="uName")
	private String userName;
	
	@Column(name="pswd")
	private String password;
	
	@Column(name="phoneNo")
	private long phone;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(cascade={CascadeType.PERSIST}, fetch=FetchType.EAGER, mappedBy="user")
	private List<UserAdv> ad_list;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", phone=" + phone + ", email=" + email + "]";
	}

	
	

	
	
}
