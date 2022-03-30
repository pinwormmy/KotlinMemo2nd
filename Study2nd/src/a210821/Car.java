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
				System.out.println("������ �����ϴ�. ���� �Ϸ�ñ��� " +  "��ٷ��ֽñ� �ٶ��ϴ�.");
				this.wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		carName = (String)carList.remove(carList.size()-1);
		System.out.println("���Բ��� ������ �����߽��ϴ�. " + "�����Ͻ� ���� " + carName + "�Դϴ�.");
		return carName;
	}
	
	public synchronized void push(String car) {
		carList.add(car);
		System.out.println("���� ������ �Ϸ�Ǿ����ϴ�. " + "����� ���� " + car + "�Դϴ�.");
		if(carList.size()==5) {
			this.notify();
		}
	}
}
