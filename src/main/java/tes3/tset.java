package tes3;

/**
 * 抢票模拟
 * 
 * @author maozhibin
 *
 */
public class tset extends Thread {

	public static void main(String[] args) {
		int people = 100000;
		piao piao = new piao();
		Thread[] thread = new Thread[people];
		for (int i = 1; i < people; i++) {
			thread[i] = new Thread(piao);
			thread[i].start();
		}
	}
}
