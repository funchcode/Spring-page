package org.zerock.expert001;

public class Driver {
	public static void main(String[] args) {
//		Car car = new Car();
		Tire tire = new KoreaTire();
		Car car = new Car(tire);
		String result = car.getTireBrand();
		System.out.println(result);
	}
}
