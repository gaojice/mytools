package thread;

public class MultiThread {

	public static void main(String[] a) {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			Thread thread = new Thread(new Worker());
			thread.start();

		}
	}

}

class Worker implements Runnable {

	public void run() {
		while (true) {
			try {
				Throwable t = new BusinessException("a", "b");
				System.out.println(Thread.currentThread() + " " + t.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}