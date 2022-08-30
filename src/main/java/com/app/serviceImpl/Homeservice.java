package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import com.app.daoImpl.HomeDao;
import com.app.model.User;
import com.app.serviceInterface.Iservice;
@Service
public   class Homeservice implements Iservice{

	 
	@Autowired
	private HomeDao homedao;
	
	@Override
	public int saveUser(User user) {
 
		   int id= homedao.saveUser(user);
		
		return id;
	}

	@Override
	public int logincheck(String uname, String password) {
		     
	int	id=(int)   homedao.checklogin(uname, password);
		 
	                 
		return id;
	}

	public List<User> getAllUsers() {
		 
		List<User> list =homedao.getAllUsers();
		 
		return list ;
	}

	@Override
	public int changepassword(String uname , String password ,  String newpw , String reEnterpw) {
		// TODO Auto-generated method stub
		
		       int id = (int)homedao.changepassword(uname, password, newpw, reEnterpw);
		return id;
	}

	@Override
	public User userdata(String uname) {
		// TODO Auto-generated method stub
		
		User  user = homedao.userdata(uname);
		return user;
	}

	@Override
	public User editUser(int uid) {
		// TODO Auto-generated method stub
		return homedao.editUser(uid);
	}

	@Override
	public List<User> deleteuser(int uid) {
		// TODO Auto-generated method stub
		return homedao.deleteuser(uid);
	}

	@Override
	public List<User>  updateuser(User user) {
		// TODO Auto-generated method stub
		List<User> list1=homedao.updateuser(user);
		return list1;
	}

 
	 

}
