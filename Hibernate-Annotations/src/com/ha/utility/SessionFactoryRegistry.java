package com.ha.utility;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.ha.entities.Vehicle;

public class SessionFactoryRegistry {
	
	private static SessionFactory sessionfactory;
	private static Map setting;
	
	static {
		
		setting = new HashMap();
		setting.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		setting.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/akansha");
		setting.put("hibernate.connection.username", "root");
		setting.put("hibernate.connection.username", "root");
		setting.put("hibernate.hbm2ddl.auto", "update");
		setting.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		MetadataSources metadatasources = new MetadataSources(new StandardServiceRegistryBuilder().applySettings(setting).build());
		metadatasources.addAnnotatedClass(Vehicle.class);
		sessionfactory = metadatasources.buildMetadata().buildSessionFactory();
		
	}

	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	
	public static void closeSessionFactory()
	{
		if(sessionfactory != null)
		{
			sessionfactory.close();
		}
	}
	

}
