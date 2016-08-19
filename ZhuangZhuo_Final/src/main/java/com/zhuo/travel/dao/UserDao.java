package com.zhuo.travel.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zhuo.travel.model.Order;
import com.zhuo.travel.model.User;



public class UserDao extends DAO{
	public User queryUserByNameAndPassword(String name, String password)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from User where userName = :Name and password = :Password");
            q.setString("Name", name);
            q.setString("Password", password);
            User user = (User) q.uniqueResult();
     //       commit();
            return user;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + name, e);
        }
    }
	
	public User queryUserByName(String name) throws Exception
	{
		 try {
		      //      begin();
		            Query q = getSession().createQuery("from User where userName = :UserName");
		            q.setString("UserName", name);
		            User user = (User) q.uniqueResult();
		     //       commit();
		            return user;
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get user ",e);
		        }
		
	}
	
	public boolean addUser(String userName, String pass, String email) throws Exception
	{
		 try {
		            //begin();
			 Session session = getSession();
			 session.beginTransaction(); 
		            User c = new User();
		           c.setEmail(email);
		           c.setPassword(pass);
		           c.setUserName(userName);
		            session.save(c);
		          
		          session.getTransaction().commit();
		      
		            return true;
		        } catch (HibernateException e) {
		            //rollback();
		            throw new Exception("Could not insert order" , e);
		        }
	}
	
	
}
