package com.ha.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.ha.entities.Vehicle;
import com.ha.utility.SessionFactoryRegistry;



public class Test {

	public static void main(String[] args) {
		SessionFactory sessionfactory = SessionFactoryRegistry.getSessionfactory();
		Session session = sessionfactory.openSession();
		Vehicle vehicle = session.get(Vehicle.class, "MH-001");
		System.out.println(vehicle.getVehicleNo());
		System.out.println(vehicle.getClass().getCanonicalName());
		
		session.close();
	}
	
	public static void store(Session session)
	{
		Transaction transaction = null;
		boolean flag = false;
	
		try {
	
	
		Vehicle vehicle = new Vehicle();
		transaction = session.beginTransaction();
		vehicle.setVehicleNo("MH-001");
		vehicle.setRegistrationNo("sbcjsxj");
		session.save(vehicle);
		flag=true;
		transaction.commit();
	
		}finally {
		if(session != null)
			if(flag)
			{
				transaction.commit();
			}else
			{
				transaction.rollback();
			}
		}
	}


}
