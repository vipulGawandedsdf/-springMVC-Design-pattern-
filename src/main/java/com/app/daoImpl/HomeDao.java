 package com.app.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.daointerface.IDao;
import com.app.model.User;
@Repository
public class HomeDao implements IDao {
@Autowired
	SessionFactory sessionFactory;
	@Override
	public int saveUser(User user) {
		// TODO Auto-generated method stub
		
	Session	session =sessionFactory.openSession();
	  
	Transaction tx=session.beginTransaction();
 	       int  id=(int)session.save(user);
	        tx.commit();
	        session.close();
 		return id;
	}
	@Override
	public int checklogin(String uname, String password) {
		 int id=0;
	Session session=sessionFactory.openSession();
	 
	     Transaction tx=session.beginTransaction();
	      
	              Query  query=  session.createQuery("from User u where u.uname='"+uname+"'and u.password ='"+password+"'");
	        
		                    List<User>     list= query.getResultList();
		                    if (list != null && !list.isEmpty()) {
		            			id = 1;
		            		}
		            		tx.commit();
		            		session.close();
		            		return id;
	}
	
	
	
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("From User u");

		List<User> list = query.getResultList();
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public int changepassword(String uname, String password, String newpw, String reEnterpw) {
		// TODO Auto-generated method stub
		int id=0;
		Session session = sessionFactory.openSession();
     Transaction tx=session.beginTransaction();
		Query query = session.createQuery("from User  where uname='" + uname + "'");

		User userinfo = (User) query.getSingleResult();

		              
		String oldpass = userinfo.getPassword();
		if (oldpass.equals(password)&&newpw.equals(reEnterpw)) {
			
			 
				Session session1 = sessionFactory.openSession();
				session1.getTransaction().begin();
				Query<User> query1 = session1.createQuery("update User u set u.password='" + reEnterpw + "'where u.uname='" + uname + "' ");

				query1.executeUpdate();
				session1.getTransaction().commit();
				session1.close();
				id=1;

			}
		 
	  
		tx.commit();
		session.close();
	 
		return id;
		}
	@Override
	public User userdata(String uname) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.openSession();
		    
		   Query query=  session.createQuery("from User u where uname ='"+uname+"'");
		               
		                   User user=(User) query.getSingleResult();
		   
		   
		   return user;
 
	}
	 

	@Override
	public List<User> deleteuser(int uid) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Query query = session.createQuery("delete from User u where u.uid='" + uid + "'");

		  int id=query.executeUpdate();
		  tx.commit();
          session.close();
          Session session1 = sessionFactory.openSession();
		           Query query1=session1.createQuery("from User u");
		           Transaction tx1=session1.beginTransaction();
		                   List<User>   user1= query1.getResultList();
		                   tx1.commit();
		                   session1.close();
		                   
		return user1;
	}
	 
	public User editUser(int uid)
	{
		
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		  Query query= session.createQuery("from User u where u.uid ='" + uid + "'");
		       
		                  List<User>  list=query.list();
		     
		                  User user = new User();

		          		if (list != null && !list.isEmpty()) {
		          			for (User u1 : list) {
		          				user = u1;
		          			}
		          		 
		          		 
		          
		          		}
		  
		          		return user;
	}
	@Override
	public List<User>  updateuser(User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		    Query  query=   session.createQuery("Update User u set u.name ='"+user.getName()+"', u.uname='"+user.getUname()+"', u.password ='"+user.getPassword()+"'where u.uid ='" + user.getUid() + "'");
		    		
		  query.executeUpdate();
		     tx.commit();
		     session.close();
		     Session session1 = sessionFactory.openSession();
		            Query     query1= session1.createQuery("from User u");
		        	Transaction tx1 = session1.beginTransaction();
		                    List<User>  list1=   query1.getResultList();
		                   for (User user2 : list1) {
		                	   System.out.println(user2.getName());
						 }
		            		 
		return list1;
	}
	 
	 
	 

}