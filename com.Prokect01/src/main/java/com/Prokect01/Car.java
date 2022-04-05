package com.Prokect01;

@SuppressWarnings({ "all" })
public class Car {
	private double odometer;
	private String model;
	private LargeEngine largeEngine;
	
	//parameters constructor
	public Car(double odometer, String model, LargeEngine largeEngine) {
		this.odometer = odometer;
		this.model = model;
		this.largeEngine = largeEngine;
	}
	
	//getter method
	public double getOdometer() {
		return odometer;
	}
	
	public void startEngine() {
		System.out.println("Model: " + this.model + " ");
		largeEngine.start();
	}

}
