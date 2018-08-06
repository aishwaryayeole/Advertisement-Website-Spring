package com.spring_hibernate.AdvertisementWebsite.controller;

import java.util.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring_hibernate.AdvertisementWebsite.entity.User;
import com.spring_hibernate.AdvertisementWebsite.services.UserService;
import com.spring_hibernate.AdvertisementWebsite.tables.Actions;
import com.spring_hibernate.AdvertisementWebsite.tables.Categories;
import com.spring_hibernate.AdvertisementWebsite.tables.SessionTable;
import com.spring_hibernate.AdvertisementWebsite.tables.UserAdv;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/xornet")
public class UserController {

	@Autowired
	UserService userAdDaoService;
	
	
	@RequestMapping(value="/register", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String createUser(@RequestBody User user)
	{
		System.out.println("User Details: "+user);
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("data",userAdDaoService.createUser(user));
		return jsonobj.toString();
	}
	
	@RequestMapping(value="/loginUser", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String loginUser(@RequestBody User user)
	{
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("auth-token",userAdDaoService.loginUser(user));
		return jsonobj.toString();	
	}
	
	@RequestMapping(value="/logoutUser", method=RequestMethod.DELETE)
	public @ResponseBody String logoutUser(@RequestHeader (value="auth-token") Long authToken)
	{
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("logout",userAdDaoService.logoutUser(authToken));
		return jsonobj.toString();	
	}

	
	@RequestMapping(value="/items", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Categories> CategoriesUser()
	{
		return userAdDaoService.CategoriesUser();
	}
	
	@RequestMapping(value="/actions", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Actions> ActionsUser()
	{
		return userAdDaoService.ActionsUser();
	}
	
	@RequestMapping(value="/postad", method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String postAdv(@RequestBody UserAdv userAdv,
											@RequestHeader (value="auth-token") Long authToken)
	{
		System.out.println("User Details: "+userAdv+" "+authToken);
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("data",userAdDaoService.postAdv(authToken,userAdv));
		return jsonobj.toString() ;
	}
	
	@RequestMapping(value="/getads", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserAdv> getAdv(@RequestHeader (value="auth-token") Long authToken)
	{
		return userAdDaoService.getAdv(authToken);
	
	}
	
	@RequestMapping(value="/getallads", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserAdv> getAllAdv()
	{
		return userAdDaoService.getAllAdv();
	
	}
	
	@RequestMapping(value="/deleteAd", method=RequestMethod.DELETE)
	public @ResponseBody String deleteAdv(@RequestParam(name="postId") Long postId)
	{
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("data",userAdDaoService.deleteAdv(postId));
		return jsonobj.toString();	
	}

	@RequestMapping(value="/search", method=RequestMethod.GET)
	public @ResponseBody List<UserAdv> searchAdv(@RequestHeader (value="auth-token") Long authToken,@RequestParam(name="category") String category)
	{
		return userAdDaoService.searchAdv(authToken,category);
	}
	
	@RequestMapping(value="/userdetails", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<User> getUserDetails(@RequestHeader (value="auth-token") Long authToken)
	{
		
		return userAdDaoService.getUserDetails(authToken);
	
	}
	
	@RequestMapping(value="/searchbar", method=RequestMethod.GET)
	public @ResponseBody List<UserAdv> searchAdvBar(@RequestHeader (value="auth-token") Long authToken,@RequestParam(name="keyword") String keyword)
	{
		return userAdDaoService.searchAdvBar(authToken,keyword);
	}
	
	
}
