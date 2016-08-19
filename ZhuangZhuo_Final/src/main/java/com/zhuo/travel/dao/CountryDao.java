package com.zhuo.travel.dao;

import java.util.ArrayList;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.zhuo.travel.model.Country;


public class CountryDao extends DAO{

	public ArrayList<Country> queryCountry()
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Country");
            ArrayList<Country> countrylist = new ArrayList<Country>();
            countrylist = ((ArrayList<Country>) q.list());
     //       commit();
            return countrylist;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get country ");
        }
    }

}
