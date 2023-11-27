package com.qsp.oto.view;

import java.util.Scanner;

import com.qsp.oto.controller.Controller;
import com.qsp.oto.model.Car;
import com.qsp.oto.model.Engine;

public class View {
	static Scanner myInput = new Scanner(System.in);
	static Controller controller = new Controller();
	public static void main(String[] args) {
		
		do {
			
			System.out.println("Select Operation to Perform : ");
			System.out.println("1.Add Car\n2.Remove Car\n3.Update Car Details\n4.Fetch Car\n0.Exit");
			System.out.print("Enter Digit Respective to Desired Option : ");
			
			int userInput = myInput.nextInt();
			myInput.nextLine();
			
			switch (userInput) {
			case 0:
				myInput.close();
				System.out.println("---- EXITED ----");
				System.exit(0);
				break;
			case 1:
				//Add Car
				
				Car car = new Car();
				System.out.print("Enter Car id : ");
				car.setId(myInput.nextInt());
				myInput.nextLine();
				System.out.print("Enter Car Name : ");
				car.setCar_name(myInput.nextLine());
				System.out.print("Enter Chasis : ");
				car.setChasis(myInput.nextLine());
				System.out.print("Enter Car Cost : ");
				car.setCost(myInput.nextInt());
				myInput.nextLine();
				
				Engine engine = new Engine();
				System.out.print("Enter Engine id : ");
				engine.setId(myInput.nextInt());
				myInput.nextLine();
				System.out.print("Enter CC : ");
				engine.setCc(myInput.nextDouble());
				System.out.print("Enter No Of Cylinder : ");
				engine.setNo_of_cy((byte)myInput.nextInt());
				myInput.nextLine();
				
				car.setEngine(engine);
				
				boolean addCar = controller.addCar(car, engine);
				System.out.println(addCar);	
				break;
				
			case 2:
				// Remove car
				System.out.println("Enter Car id to Remove : ");
				int carIdToDelete = myInput.nextInt();
				myInput.nextLine();
				
				if (controller.removeCar(carIdToDelete)) {
					System.out.println("Remove car");
				} else {
					System.out.println("car eith given id does not exist");
				}
				
				break;
			case 3:
				// Update Car
				System.out.println("Enter Car Id to Update : ");
				int carIdToUpdate = myInput.nextInt();
				myInput.nextLine();
				System.out.println("please enter updated price : ");
				double carCostToUpdate = myInput.nextDouble();
				myInput.nextLine();
				
				if (controller.updateCar(carIdToUpdate, carCostToUpdate)) {
					System.out.println("Car update Successful");
				} else {
					System.out.println("car with given id does not exist");
				}
				break;
			case 4:
				//Fetch car
				 
				System.out.print("Enter Car id to fetch : ");
				int carIdToFind = myInput.nextInt();
				myInput.nextLine();
				
				Car car1 = controller.fetchCar(carIdToFind);
				if (car1 !=null) {
					System.out.println("Car Id : "+car1.getId());
					Engine engine1 = car1.getEngine();
					System.out.println("Engine Id : "+ engine1.getId());
					System.out.println("CC : "+engine1.getCc());
					System.out.println("No of Cylinder : "+engine1.getNo_of_cy());
					
				} else {
					System.out.println("Car with given id does not exist");
				}
				break;
			default:
				System.out.println("---- INVALID SELECTION ----");
				break;
			}
			
		} while (true);
	}
}
