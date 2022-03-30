package a210819;

class SuperThreadPriority extends Thread{
	public SuperThreadPriority(String threadName) {
		super(threadName);
	}
	public void run() {
		System.out.printf("스레드 이름 : %s %n", Thread.currentThread().getName());
	}
}

public class PriorityChangeEx extends SuperThreadPriority{
	public PriorityChangeEx(String threadName) {
		super(threadName);
	}
	
	public static void main(String arg[]) {
		Thread t1 = new SuperThreadPriority("첫번째 스레드");
		Thread t2 = new SuperThreadPriority("두번째 스레드");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
	}
}
