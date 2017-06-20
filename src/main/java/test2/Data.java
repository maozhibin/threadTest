package test2;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Data {
	private static String data = "Hello";
	ReadWriteLock lock = new ReentrantReadWriteLock();

	public String getData() {
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName() + "开始读取数据！");
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return data;
		} finally {
			System.out.println(Thread.currentThread().getName() + "数据读取完成！");
			lock.readLock().unlock();
		}
	}

	public void set(String data) {
		lock.writeLock().lock();
		System.out.println(Thread.currentThread().getName() + "开始写入数据");
		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "写入数据为：" + data);
			this.data = this.data + data;
		} finally {
			System.out.println(Thread.currentThread().getName() + "数据写入完成");
			lock.writeLock().unlock();
		}
	}
}