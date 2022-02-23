package com.User.Util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.User.Model.User;

public class HibernateUtil {


	private static SessionFactory sessionfactory;

	public static SessionFactory getSessionFactory()
	{

		if(sessionfactory==null)
		{
			try {


				Configuration configuration=new Configuration();
				Properties properties =new Properties();
				properties.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				properties.put(Environment.URL,"jdbc:mysql://localhost:3306/data");
				properties.put(Environment.USER,"root");
				properties.put(Environment.PASS,"Anuj@1909");
				properties.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				properties.put(Environment.SHOW_SQL,"true");
				properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");

				properties.put(Environment.HBM2DDL_AUTO,"update");
				configuration.setProperties(properties);
				configuration.addAnnotatedClass(User.class);
				ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

				sessionfactory=configuration.buildSessionFactory(serviceRegistry);
				return sessionfactory;


			}
			catch(Exception e) {
				e.printStackTrace();    

			}

		}
		return sessionfactory;

	}
}
