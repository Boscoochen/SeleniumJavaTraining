package com.Prokect01;

import org.testng.annotations.Test;

public class CarTests {
	@Test
	public void canBuildCar() {
		Car corvette = new Car(1000.2, "corvette", new LargeEngine());
		corvette.startEngine();
		System.out.println("odometer= " + corvette.getOdometer());
	}
}
