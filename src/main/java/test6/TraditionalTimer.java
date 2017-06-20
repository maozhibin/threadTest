package test6;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator @zsw 2012-7-19 下午04:37:19
 */
public class TraditionalTimer {
	public static void main(String[] args) {
		// 1:
		// test1();

		// 2:
		// test2();

		// 3:
		test3();
		// 用于打印时间秒数
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	// 1:固定时间后执行一次任务：1000毫秒后执行任务(只执行一次)
	public static void test1() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing!");
			}
		}, 1000);
	}

	// 2:5000毫秒后，执行任务，以后每隔1000毫秒再执行一次任务(无限执行)
	public static void test2() {
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("bombing!");
			}
		}, 5000, 1000);
	}

	// 3:交替再生：任务2秒4秒交替的执行(无限执行)，
	static int count = 0;

	public static void test3() {

		class MyTimerTask extends TimerTask {
			public void run() {
				count = (count + 1) % 2;
				System.out.println("bombing!");
				new Timer().schedule(new MyTimerTask(), 2000 + count * 2000);
			}
		}
		new Timer().schedule(new MyTimerTask(), 2000);
	}

}