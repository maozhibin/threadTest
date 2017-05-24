package test;

class Fork {
	/* 5只筷子，初始为都未被用 */
	private boolean[] used = { false, false, false, false, false, false };

	/* 只有当左右手的筷子都未被使用时，才允许获取筷子，且必须同时获取左右手筷子 */
	public synchronized void takeFork() {
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);
		while (used[i] || used[(i + 1) % 5]) {
			try {
				wait();// 如果左右手有一只正被使用，等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		used[i] = true;
		used[(i + 1) % 5] = true;
	}

	/* 必须同时释放左右手的筷子 */
	public synchronized void putFork() {
		String name = Thread.currentThread().getName();
		int i = Integer.parseInt(name);

		used[i] = false;
		used[(i + 1) % 5] = false;
		notifyAll();// 唤醒其他线程
	}
}