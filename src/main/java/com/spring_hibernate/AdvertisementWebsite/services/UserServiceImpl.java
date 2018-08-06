package com.spring_hibernate.AdvertisementWebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_hibernate.AdvertisementWebsite.dao.UserDAO;
import com.spring_hibernate.AdvertisementWebsite.entity.User;
import com.spring_hibernate.AdvertisementWebsite.tables.Actions;
import com.spring_hibernate.AdvertisementWebsite.tables.Categories;
import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;



public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	public String createUser(User user) {
		return userDao.createUser(user);
	}

	public String loginUser(User user) {
		return userDao.loginUser(user);
	}

	public String logoutUser(Long authToken) {
		return userDao.logoutUser(authToken);
	}

	public List<Categories> CategoriesUser() {
		return userDao.CategoriesUser();
	}

	public List<Actions> ActionsUser() {
		return userDao.ActionsUser();
	}

	public String postAdv(Long id, UserAdv userAdv) {
		return userDao.postAdv(id,userAdv);
	}

	public List<UserAdv> getAdv(Long authToken) {
		return userDao.getAdv(authToken);
	}

	public String deleteAdv(Long postId) {
		return userDao.deleteAdv(postId);
	}

	public List<UserAdv> searchAdv(Long authToken, String category) {
		return userDao.searchAdv(authToken,category);

	}

	public List<UserAdv> getAllAdv() {
		return userDao.getAllAdv();
	}

	public List<User> getUserDetails(Long authToken) {
		return userDao.getUserDetails(authToken);
	}

	public List<UserAdv> searchAdvBar(Long authToken, String keyword) {
		return userDao.searchAdvBar(authToken,keyword);
	}

}
