package threadlocal;

public class ThreadLocalTest implements Runnable {
	static class Counter {
		int c = 0;

		public void Count() {
			System.out.println(Thread.currentThread().hashCode() + ": " + c++);
		}
	}

	@SuppressWarnings("rawtypes")
	private static ThreadLocal counter = new ThreadLocal() {
		protected Object initialValue() {
			return new Counter();
		}
	};

	public static Counter Counter() {
		return (Counter) counter.get();
	}

	public static void main(String[] args) throws Exception {
		ThreadLocalTest h = new ThreadLocalTest();
		h.run();
		new Thread(new ThreadLocalTest()).start();
		Thread.sleep(1000L);
		// h.run();
		Counter().Count();
	}

	public void run() {
		Counter().Count();
		Counter().Count();
		Counter().Count();
	}
}
