package com.qsp.oto.controller;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import com.qsp.oto.model.Car;
import com.qsp.oto.model.Engine;

public class Controller {

	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();

	//Method to add Car
	public boolean addCar(Car car, Engine engine) {
		
		if (car != null && engine != null) {
			entityTransaction.begin();
			entityManager.persist(car);
			entityManager.persist(engine);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	
	//Method to Fetch Car
	public Car fetchCar(int car_id) {
				
		return entityManager.find(Car.class, car_id);
	
	}
	//Method to Update Car
	public boolean updateCar(int car_id, double updated_cost) {
		Car car = fetchCar(car_id);
		if (car!=null) {
			car.setCost(updated_cost);
			entityTransaction.begin();
			entityManager.merge(car);
			entityTransaction.commit();
			return true;
		} 
		return false;
	}
	
	//Method to Remove Car
	public boolean removeCar(int car_id) {
		Car car = fetchCar(car_id);
		
		if (car!=null) {
			entityTransaction.begin();
			entityManager.remove(car);
			entityManager.remove(car.getEngine());
			entityTransaction.commit();
			
			return true;
		} 
		return false;
	}
	
}
