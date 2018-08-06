package com.spring_hibernate.AdvertisementWebsite.services;

import java.util.Collection;
import java.util.List;

import com.spring_hibernate.AdvertisementWebsite.entity.User;
import com.spring_hibernate.AdvertisementWebsite.tables.Actions;
import com.spring_hibernate.AdvertisementWebsite.tables.Categories;
import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;


public interface UserService {

	public String createUser(User user);

	public String loginUser(User user);

	public String logoutUser(Long authToken);

	public List<Categories> CategoriesUser();

	public List<Actions> ActionsUser();

	public String postAdv(Long id, UserAdv userAdv);

	public List<UserAdv> getAdv(Long authToken);

	public String deleteAdv(Long postId);

	public List<UserAdv> searchAdv(Long authToken, String category);

	public List<UserAdv> getAllAdv();

	public List<User> getUserDetails(Long authToken);

	public List<UserAdv> searchAdvBar(Long authToken, String keyword);




}
