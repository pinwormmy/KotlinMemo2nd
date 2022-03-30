package a210821;

import java.util.*;

public class Car {
	private List<String> carList = null;
	public Car() {
		carList = new ArrayList<String>();
	}
	public String getCar() {
		String carName = null;
		switch((int)(Math.random() * 3)) {
		case 0 : carName = "Benz S350d";
		break;
		case 1 : carName = "Audi A4";
		break;
		case 2 : carName = "BMW 520d";
		break;
		}
		return carName;
	}
	public synchronized String pop() {
		String carName = null;
		if(carList.size()==0) {
			try {
				System.out.println("차량이 없습니다. 생산 완료시까지 " +  "기다려주시기 바랍니다.");
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		carName = (String)carList.remove(carList.size()-1);
		System.out.println("고객님께서 차량을 구매했습니다. " + "구매하신 모델은 " + carName + "입니다.");
		return carName;
	}
	
	public synchronized void push(String car) {
		carList.add(car);
		System.out.println("차량 생산이 완료되었습니다. " + "생산된 모델은 " + car + "입니다.");
		if(carList.size()==5) {
			this.notify();
		}
	}
}
