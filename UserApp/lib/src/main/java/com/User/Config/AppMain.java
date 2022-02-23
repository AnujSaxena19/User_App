package com.User.Config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.User.Dao.UserDao;

public class AppMain {

	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("com/User/Config/config.xml");
		
		UserDao userObject= context.getBean("login",UserDao.class);
		
		userObject.getAllUser();
		
	}

}