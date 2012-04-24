package classloader;

public class Test {
	public void sysout1() {
		System.out.println("a");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Test().sysout1();
	}

}
