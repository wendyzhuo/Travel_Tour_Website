package com.zhuo.travel.dao;

import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;



public class TripDao extends DAO{
	public ArrayList<Trip> queryAgent(int name)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Trip where agentID = :UserName");
            q.setInteger("UserName", name);
            ArrayList<Trip> countrylist = new ArrayList<Trip>();
            countrylist = ((ArrayList<Trip>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get Trips ");
        }
    }
	
	
	public Trip queryTrip(Integer name) throws Exception
	{
		 try {
		      //      begin();
		            Query q = getSession().createQuery("from Trip where tripID = :UserName");
		            q.setInteger("UserName", name);
		            Trip t = (Trip) q.uniqueResult();
		     //       commit();
		            return t;
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get trip ",e);
		        }
		
	}
	
	public ArrayList<Trip> querySearch(String name, int date,int year) throws Exception
	{
		 try {
		      //      begin();
			 Query q;
			 if(date==0){
				// System.out.println("indao "+date);
				  q = getSession().createQuery("from Trip where destination = :UserName");
				  q.setString("UserName", name);
			 }else{
		          q = getSession().createQuery("from Trip where destination = :UserName and month>= :m and year= :y");
		          q.setString("UserName", name);
		          q.setInteger("m", date);
		          q.setInteger("y", year);
			 }
		           
		            ArrayList<Trip> countrylist = new ArrayList<Trip>();
		            countrylist = ((ArrayList<Trip>) q.list());
		     //       commit();
		            return countrylist;
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get trip ",e);
		        }
		
	}
	
	public boolean queryavail(Integer id, String peo) throws Exception
	{
		 try {
		      //      begin();
			 Session session = getSession();
			 session.beginTransaction(); 
		            Query q = session.createQuery("UPDATE Trip set availpeo = :avail WHERE tripID = :id");
		            q.setString("avail", peo);
		            q.setInteger("id", id);
		            q.executeUpdate();
		            session.getTransaction().commit();
		     //       commit();
		            return true;
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not get trip ",e);
		        }
		
	}
	
	public boolean addTrip(int aid , int m1,int m2, String avail, String destination, String itinerarys, String overview, String picurl, String title,
			Date d1, Date d2, int m, int y, float p) throws Exception
	{
		 try {
		            //begin();
			 
			
				 Session session = getSession();
				 session.beginTransaction(); 
				 Trip t = new Trip();
				 t.setAgentID(aid);
				 t.setAvailpeo(avail);
				 t.setDateFrom(d1);
				 t.setDateTo(d2);
				 t.setDestination(destination);
				 t.setItinerarys(itinerarys);
				 t.setMaxAge(m1);
				 t.setMinAge(m2);
				 t.setMonth(m);
				 t.setYear(y);
				 t.setOverview(overview);
				 t.setPicurl(picurl);
				 t.setPrice(p);
				 t.setTitle(title);
				  session.save(t);
		          session.getTransaction().commit();
			 
		           
		           
		            	return true;
		            //commit();
		        } catch (HibernateException e) {
		            //rollback();
		            throw new Exception("Could not insert contact" , e);
		        }
	}
	
	
	public void deleteTrip(String[] contactSet) throws Exception
	{
		try {
		      //      begin();
			for(int i =0; i < contactSet.length;i++)
            {
			 Session session = getSession();
			 session.beginTransaction(); 
//		        	String hql = "delete from Trip where tripID = :contactID"; 
//		            Query q = session.createQuery(hql);
//		            	q.setInteger("contactID", Integer.parseInt(contactSet[i]));
//		            	q.executeUpdate();
//		            	session.delete(product);
					 int tripID = Integer.parseInt(contactSet[i]);
					 Trip t = new Trip();
					 t.setTripID(tripID);
					 session.delete(t);
			 
		            	  session.getTransaction().commit();
		            	  session.close();
		            }
		     //       commit();
		        } catch (HibernateException e) {
		     //       rollback();
		            throw new Exception("Could not delete trip", e);
		        }
	}

	public ArrayList<Trip> queryAllAgent()
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Trip ");
            q.setMaxResults(5);
            ArrayList<Trip> countrylist = new ArrayList<Trip>();
            countrylist = ((ArrayList<Trip>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get Trips ");
        }
    }
}
