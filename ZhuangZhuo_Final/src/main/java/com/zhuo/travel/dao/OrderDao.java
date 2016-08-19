package com.zhuo.travel.dao;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zhuo.travel.model.Order;


@Transactional
public class OrderDao extends DAO{
	public ArrayList<Order> queryOrder(int name)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Order where uid = :UserName");
            q.setInteger("UserName", name);
            ArrayList<Order> countrylist = new ArrayList<Order>();
            countrylist = ((ArrayList<Order>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get order ");
        }
    }
	
	
	public Integer addOrder(Integer peoplenum, Integer tripid, Integer userid, String destination) throws Exception
	{
		 try {
		            //begin();
			 Session session = getSession();
			 session.beginTransaction(); 
		            Order c = new Order();
		            c.setDestination(destination);
		            c.setPeopleNum(peoplenum);
		            c.setTripID(tripid);
		            c.setUid(userid);
		            session.save(c);
		            int a = c.getOrderID();
		          session.getTransaction().commit();
		      
		            return a;
		        } catch (HibernateException e) {
		            //rollback();
		            throw new Exception("Could not insert order" , e);
		        }
	}
}
