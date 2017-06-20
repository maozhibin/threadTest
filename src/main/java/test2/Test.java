package test2;

public class Test {
	public static void main(String[] args) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++)
					System.out.println(Thread.currentThread().getName() + "读取到的数据为：" + new Data().getData());
			}
		}.start();
		new Thread() {
			public void run() {
				for (int i = 0; i < 10; i++) {
					new Data().set(String.valueOf(i));
				}
			}
		}.start();
	}
}