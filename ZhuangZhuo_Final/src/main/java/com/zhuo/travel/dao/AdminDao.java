package com.zhuo.travel.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.zhuo.travel.model.Admin;
import com.zhuo.travel.model.Agent;



public class AdminDao extends DAO{
	
	public Admin queryAdminByNameAndPassword(String name, String password)
            throws Exception {
        try {
      //      begin();
            Query q = getSession().createQuery("from Admin where adminName = :Name and password = :Password");
            q.setString("Name", name);
            q.setString("Password", password);
            Admin user = (Admin) q.uniqueResult();
     //       commit();
            return user;
        } catch (HibernateException e) {
     //       rollback();
            throw new Exception("Could not get user " + name, e);
        }
    }

}
