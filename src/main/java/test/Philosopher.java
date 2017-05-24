package test;

/*每个哲学家相当于一个线程*/
class Philosopher extends Thread {
	private String name;
	private Fork fork;

	public Philosopher(String name, Fork fork) {
		super(name);
		this.name = name;
		this.fork = fork;
	}

	public void run() {
		while (true) {
			thinking();
			fork.takeFork();
			eating();
			fork.putFork();
		}

	}

	public void eating() {
		System.out.println("I am Eating:" + name);
		try {
			sleep(1000);// 模拟吃饭，占用一段时间资源
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void thinking() {
		System.out.println("I am Thinking:" + name);
		try {
			sleep(1000);// 模拟思考
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}