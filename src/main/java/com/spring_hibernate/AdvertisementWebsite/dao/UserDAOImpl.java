package com.spring_hibernate.AdvertisementWebsite.dao;

import java.util.*;

import javax.persistence.Query;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.spring_hibernate.AdvertisementWebsite.entity.User;
import com.spring_hibernate.AdvertisementWebsite.tables.Actions;
import com.spring_hibernate.AdvertisementWebsite.tables.Categories;
import com.spring_hibernate.AdvertisementWebsite.tables.SessionTable;
import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;


public class UserDAOImpl extends HibernateDaoSupport implements UserDAO{
	
	
	@Transactional
	public String createUser(User user) {
		int flag=0;
		String name=user.getUserName();
		List<String> unames=(List<String>) getHibernateTemplate().find("Select userName From User");
		System.out.println("User name list: -"+unames);
		for(Object s:unames)
		{
			if(s.equals(name))
			{
				System.out.println("User name already exists");
				flag=1;
				break;
			}
		}
		if( flag==1)
			return "User name already exists";
		else
		{
			getHibernateTemplate().save(user);
			return "Successful";
		}
		
		
	}
	
	@Transactional
	public String loginUser(User user) {
		String name=user.getUserName();
		String password=user.getPassword();
	
		//List query=getHibernateTemplate().findByNamedQueryAndNamedParam("findUser", "name", name);
		List query=getHibernateTemplate().find("From User where userName= ? AND password= ?",name,password);
		System.out.println("List:- "+query);
		List<SessionTable> sessionList=(List<SessionTable>) getHibernateTemplate().find("From SessionTable where name= ?", name);
		System.out.println("SL:- "+sessionList);
		if(query.isEmpty()){
			System.out.println("in query.isEmpty()");
			return "Login Unsuccessful";

		}
		else if(sessionList.isEmpty())
		{
			System.out.println("user.getUserName():  "+user.getUserName());
			SessionTable sessionTable= new SessionTable(user.getUserName(),new Date());
			getHibernateTemplate().save(sessionTable);
			System.out.println("sessionTable.getId(): "+sessionTable.getId());
			return ""+sessionTable.getId();
		}
		else{
			System.out.println("Login Unsuccessful");
			return "Login Unsuccessful";
		}
	}

	@Transactional
	public String logoutUser(Long authToken) {
		SessionTable sessionTable=getHibernateTemplate().get(SessionTable.class, authToken);
		getHibernateTemplate().delete(sessionTable);
		return "logout";
	}

	@Transactional
	public List<Categories> CategoriesUser() {
	/*	Categories c= new Categories("Cloths");
		getHibernateTemplate().save(c);
		c= new Categories("Real-Estate");
		getHibernateTemplate().save(c);

		c= new Categories("Mobile");
		getHibernateTemplate().save(c);

		c= new Categories("Furniture");
		getHibernateTemplate().save(c);*/

		List<Categories> cat=(List<Categories>) getHibernateTemplate().find("From Categories");
		return cat;
	}

	@Transactional
	public List<Actions> ActionsUser() {
		List<Actions> act=(List<Actions>) getHibernateTemplate().find("From Actions");
		return act;	
		}

	@Transactional
	public String postAdv(Long id,UserAdv userAdv) {
		
	List<SessionTable> list=(List<SessionTable>) getHibernateTemplate().find("From SessionTable where id= ?" , id);
	String uname=list.get(0).getName();
	
	List<User> ulist=(List<User>) getHibernateTemplate().find("From User where userName=? ",uname);
	User uid=ulist.get(0);
	UserAdv u2= new UserAdv(userAdv.getTitle(), userAdv.getCategory(), userAdv.getDescription(), uid);
	getHibernateTemplate().save(u2);
	return "Adv posted";
		
	}
	
	@Transactional
	public List<UserAdv> getAdv(Long authToken) {
		List<SessionTable> list=(List<SessionTable>) getHibernateTemplate().find("From SessionTable where id= ?" , authToken);
		String uname=list.get(0).getName();
		
		List<User> ulist=(List<User>) getHibernateTemplate().find("From User where userName=? ",uname);
		Long uid=ulist.get(0).getId();
		
		List<UserAdv> adList=(List<UserAdv>) getHibernateTemplate().find("From UserAdv where user_id=? ",uid);
		System.out.println("adList: "+adList);
		return adList;
	}
	
	@Transactional
	public String deleteAdv(Long postId) {
		System.out.println("postId: "+postId);
		UserAdv userAdv=getHibernateTemplate().get(UserAdv.class, postId);
		getHibernateTemplate().delete(userAdv);
		return "Ad deleted";
	}



	public List<UserAdv> searchAdv(Long authToken, String category) {
		List<UserAdv> adCatList=(List<UserAdv>) getHibernateTemplate().find("From UserAdv where category=? ",category);
		System.out.println("Search Adv by Category: "+adCatList);
		
		return adCatList;
	
	}

	public List<UserAdv> getAllAdv() {
		List<UserAdv> adList=(List<UserAdv>) getHibernateTemplate().find("From UserAdv");
		System.out.println("Search Adv: "+adList);
		return adList;
	}

	public List<User> getUserDetails(Long authToken) {
		List<SessionTable> list=(List<SessionTable>) getHibernateTemplate().find("From SessionTable where id= ?" , authToken);
		String uname=list.get(0).getName();
		
		List<User> ulist=(List<User>) getHibernateTemplate().find("From User where userName=? ",uname);
		Long uid=ulist.get(0).getId();
		
		return ulist;
	}

	public List<UserAdv> searchAdvBar(Long authToken, String keyword) {
		List<UserAdv> matchedAds = (List<UserAdv>) getHibernateTemplate().findByNamedParam("From UserAdv u where u.title like :keyword OR u.category like :keyword", "keyword","%"+ keyword+"%");
		return matchedAds;
	}

}