package test2;

class Fork {
	// 5支筷子，未使用的时候是false状态，使用后就是true状态
	private Boolean[] used = { false, false, false, false, false, false };

	// 要使用筷子的时候，必须两边都是为使用的状态才可以用
	public synchronized void takeFork() {
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);
		while (used[i] || used[(i + 1) % 5]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		used[i] = true;
		used[(i + 1) % 5] = true;
	}

	// 必须同时释放筷子
	public synchronized void putFork() {
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);

		used[i] = false;
		used[(i + 1) % 5] = false;

		// 唤醒其他线程 notifyAll是唤醒全部等待的线程 notify()是唤醒某个线程随机的，所以这里用 notifyAll
		notifyAll();

	}

}
