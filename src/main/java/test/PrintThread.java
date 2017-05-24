package test;

public class PrintThread implements Runnable {

	private PrintCallback pcback;

	public PrintThread(PrintCallback pcback) {
		this.pcback = pcback;
	}

	public void run() {
		pcback.CallbackMethod(Thread.currentThread().getName());

	}

}