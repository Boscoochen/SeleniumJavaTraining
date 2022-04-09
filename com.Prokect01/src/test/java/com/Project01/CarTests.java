package com.Project01;

import org.testng.annotations.Test;

public class CarTests {
	@Test
	public void canBuildCar() {
		Car corvette = new Car(1000.2, "corvette");
		corvette.startEngine();
		System.out.println("odometer= " + corvette.getOdometer());
	}
}
