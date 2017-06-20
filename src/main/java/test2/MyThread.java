package test2;

class MyThread extends Thread {
	LockDemo ld;

	public MyThread(LockDemo ld) {
		this.ld = ld;
	}

	public void run() {
		ld.increaseI();
	}
}
