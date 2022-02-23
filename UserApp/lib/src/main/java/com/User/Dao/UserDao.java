package com.User.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.User.Model.User;
import com.User.Util.HibernateUtil;

public class UserDao {

	public boolean registerUser(User user)
	{
		Transaction transaction =null;
		try {
			Session session =HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			session.save(user);
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}

	}
	
	public boolean deleteUser(int id)
	{

		Transaction transaction =null;
		try {
			Session session =HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			User user = session.load(User.class, id);
			session.delete(user);
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}           

	}
	
	public List<User> getAllUser()
	{
		Transaction transaction =null;
		try {
			Session session =HibernateUtil.getSessionFactory().openSession();
			System.out.println("Session open");
			transaction=session.beginTransaction();
			Criteria cr =session.createCriteria(User.class);
			List<User> userList=cr.list();
			transaction.commit();       
			return userList;

		}

		catch(Exception e)
		{
			return null;
		}           


	}



	public boolean updateUser(int id,User user)
	{
		Transaction transaction =null;
		try {
			Session session =HibernateUtil.getSessionFactory().openSession();
			transaction=session.beginTransaction();
			User u=session.byId(User.class).load(id);
			u.setFname(user.getFname());
			u.setLname(user.getLname());
			transaction.commit();
			return true;
		}
		catch(Exception e)
		{
			return false; 
		}   
	}
}