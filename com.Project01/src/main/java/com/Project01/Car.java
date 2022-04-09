package com.Project01;

@SuppressWarnings({ "all" })
public class Car {
	private double odometer;
	private String model;
	private LargeEngine largeEngine;
	

	public Car(double odometer, String model) {
		this.odometer = odometer;
		this.model = model;
		this.largeEngine = new LargeEngine();
	}
	
	
	public double getOdometer() {
		return odometer;
	}
	
	public void startEngine() {
		System.out.println("Engine Started");
		System.out.println("Model: " + this.model + " ");
	}

}
