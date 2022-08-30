package com.app.daointerface;

import java.util.List;

import com.app.model.User;

public interface IDao {

	public int saveUser(User user);
	
	public int checklogin(String uname, String password);
	public List<User> getAllUsers();
	public int changepassword (String uname , String password ,  String newpw , String reEnterpw);
	public  User userdata( String uname);
	public User editUser(int uid);
	public List<User> deleteuser( int uid);
	public List<User>  updateuser(User user);
//	public List<User> updateUser(User user)

 
}
