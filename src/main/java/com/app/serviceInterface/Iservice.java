package com.app.serviceInterface;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.User;

public interface Iservice {
	
	public int saveUser(User user);
	public int logincheck(String uname, String password);
	public List<User> getAllUsers();
	public int changepassword (   String uname , String password ,  String newpw , String reEnterpw);
	public  User userdata(  String uname  );
	 
	public List<User> deleteuser( int uid);
	public User editUser(int uid);
	public List<User>  updateuser(User user);
	
}
