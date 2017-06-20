package test2;

class TestThread implements Runnable {
	int ticket = 50;
	String str = " ";
	int time = 50;

	public void run() {
		if (ticket > 0) {
			synchronized (str) {
				if (ticket > 0) {
					System.out.println(Thread.currentThread().getName() + ": taker  get " + ticket + " ticket");
					ticket--;
				}
			}
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}