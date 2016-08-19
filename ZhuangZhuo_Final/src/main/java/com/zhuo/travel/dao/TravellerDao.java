package com.zhuo.travel.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.zhuo.travel.model.Traveller;
import com.zhuo.travel.model.Trip;



public class TravellerDao extends DAO{
	public boolean addTraveller(int oid , int uid,int tid, String[] firstname, String[] lastname, String[] cnumber, String[] gender, String[] month, String[] year,
			String[] date, String[] email) throws Exception
	{
		 try {
		            //begin();
			 
			 for(int i = 0; i < firstname.length; i++){
				 Session session = getSession();
				 session.beginTransaction(); 
				 Traveller t = new Traveller();
				 t.setOrderID(oid);
				 t.setTripID(tid);
				 t.setUserID(uid);
				 t.setFirstName(firstname[i]);
				 t.setLastName(lastname[i]);
				 t.setGender(gender[i]);
				 t.setContactNum(cnumber[i]);
				 t.setEmail(email[i]);
				 String a = year[i]+"-"+month[i]+"-"+date[i];
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 Date d = format.parse(a);
				 t.setDateofBirth(d);
				  session.save(t);
		          session.getTransaction().commit();
			 }
		           
		           
		            	return true;
		            //commit();
		        } catch (HibernateException e) {
		            //rollback();
		            throw new Exception("Could not insert contact" , e);
		        }
	}
	
	public ArrayList<Traveller> queryTraveller(int name,int oid)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Traveller where userID = :UserName and orderID = :oid");
            q.setInteger("UserName", name);
            q.setInteger("oid", oid);
            ArrayList<Traveller> countrylist = new ArrayList<Traveller>();
            countrylist = ((ArrayList<Traveller>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get Trips ");
        }
    }
	
	
}
