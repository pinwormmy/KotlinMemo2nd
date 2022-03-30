package a210821;

public class Producer implements Runnable{
	private Car car;
	public Producer(Car car) {
		this.car = car;
	}
	public void run() {
		String carName = null;
		for(int i=0; i<20; i++) {
			carName = car.getCar();
			car.push(carName);
			try {
				Thread.sleep((int)(Math.random() * 2000));
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
