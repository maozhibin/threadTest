package tes3;

class piao implements Runnable {
	int piao = 100;
	String str = "";

	public void run() {
		if (piao > 0) {
			synchronized (str) {
				System.out.println(Thread.currentThread().getName() + "：" + piao);
				piao--;
			}
		}
	}
}
