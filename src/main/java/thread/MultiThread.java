package thread;

public class MultiThread {

	public static void main(String[] a) {
		for (int i = 0; i < 8; i++) {
			Thread thread = new Thread(new Worker());
			thread.start();

		}
	}
}

class Worker implements Runnable {

	public void run() {
		Double d = 0d;
		while (true) {
			d += 1;
		}
	}
}