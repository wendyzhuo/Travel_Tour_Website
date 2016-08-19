package com.zhuo.travel.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;




public class AgentDao extends DAO{
	public Agent queryUserByNameAndPassword(String name, String password)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Agent where username = :Name and password = :Password");
            q.setString("Name", name);
            q.setString("Password", password);
            Agent user = (Agent) q.uniqueResult();
     //       commit();
            return user;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + name, e);
        }
    }
	
	public ArrayList<Agent> queryUser()
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Agent");
            ArrayList<Agent> countrylist = new ArrayList<Agent>();
            countrylist = ((ArrayList<Agent>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user ", e);
        }
    }
	
	
	public void lockAgent(String[] contactSet) throws Exception
	{
		try {
		      //      begin();
			for(int i =0; i < contactSet.length;i++)
            {
				Session session = getSession();
				 session.beginTransaction(); 
			            Query q = session.createQuery("UPDATE Agent set approve = :avail WHERE agentID = :id");
			            q.setString("avail", "NO");
			            int tripID = Integer.parseInt(contactSet[i]);
			            q.setInteger("id", tripID);
			            q.executeUpdate();
			            session.getTransaction().commit();
		            	  session.close();
		            }
		     //       commit();
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not lock agent", e);
		        }
	}
	
	public void approveAgent(String[] contactSet) throws Exception
	{
		try {
		      //      begin();
			for(int i =0; i < contactSet.length;i++)
            {
				Session session = getSession();
				 session.beginTransaction(); 
			            Query q = session.createQuery("UPDATE Agent set approve = :avail WHERE agentID = :id");
			            q.setString("avail", "YES");
			            int tripID = Integer.parseInt(contactSet[i]);
			            q.setInteger("id", tripID);
			            q.executeUpdate();
			            session.getTransaction().commit();
		            	  session.close();
		            }
		     //       commit();
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not APPROVE agent", e);
		        }
	}
	
	public boolean addAgent(String userName, String pass, String ein) throws Exception
	{
		 try {
		            //begin();
			 Session session = getSession();
			 session.beginTransaction(); 
		            Agent c = new Agent();
		          c.setApprove("NO");
		          c.setEin(ein);
		          c.setPassword(pass);
		          c.setUsername(userName);
		            session.save(c);
		          
		          session.getTransaction().commit();
		      
		            return true;
		        } catch (HibernateException e) {
		            //rollback();
		            throw new Exception("Could not insert agent" , e);
		        }
	}
	
}
