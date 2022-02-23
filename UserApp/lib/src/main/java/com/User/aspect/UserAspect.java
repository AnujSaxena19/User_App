package com.User.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class UserAspect {

	
	 @Before("execution(* com.User.Dao.UserDao.getAllUser())") 
	 public void getAllDetails() { 
		 System.out.println("Getting all the details of the user");
	 }
	  
	 @After("execution(* com.User.Dao.UserDao.getAllUser())")
	 public void getAll() { 
		 System.out.println("Getting all the details of the user after the execution");
	}
	 
}
