package org.zerock.expert001;

public class Car {
	Tire tire;
	
//	public Car() {
//		tire = new KoreaTire();
//	}
	
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	public String getTireBrand() {
		return "장착된 타이어 : " +	tire.getBrand();
	}
}
