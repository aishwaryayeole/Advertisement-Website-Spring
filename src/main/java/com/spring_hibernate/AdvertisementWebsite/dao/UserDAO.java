package com.spring_hibernate.AdvertisementWebsite.dao;


import java.util.List;

import com.spring_hibernate.AdvertisementWebsite.entity.User;
import com.spring_hibernate.AdvertisementWebsite.tables.Actions;
import com.spring_hibernate.AdvertisementWebsite.tables.Categories;
import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;


public interface UserDAO {

	String createUser(User user);

	String loginUser(User user);

	String logoutUser(Long authToken);

	List<Categories> CategoriesUser();

	List<Actions> ActionsUser();

	String postAdv(Long id,UserAdv userAdv);

	List<UserAdv> getAdv(Long authToken);

	String deleteAdv(Long postId);

	List<UserAdv> searchAdv(Long authToken, String category);

	List<UserAdv> getAllAdv();

	List<User> getUserDetails(Long authToken);

	List<UserAdv> searchAdvBar(Long authToken, String keyword);

}
