package test6;

//编写一个有子方法（用来调用子线程）和主方法（调用主线程）的业务类  
class Business {
	private boolean bShouldSub = true;

	public synchronized void sub(int i) {
		while (!bShouldSub) {
			try {
				// 如果没轮到自己就等一会
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 10; j++) {
			System.out.println("sub thread sequence of  " + j + " ,loop of  " + i);
		}
		bShouldSub = false;
		// 唤醒下一个等待的线程
		this.notify();
	}

	public synchronized void main(int i) {
		/*
		 * 这里最好用while，但是跟if的效果一样，只是前者代码更健壮， while可以防止线程自己唤醒自己，即通常所说的伪唤醒；
		 * 相当于一个人做梦不是被别人叫醒而是自己做噩梦突然惊醒； 这时用while可以防止这种情况发生
		 */
		while (bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (int j = 1; j <= 100; j++) {
			System.out.println("main thread sequence of  " + j + " ,loop of  " + i);
		}
		bShouldSub = true;
		this.notify();
	}
}