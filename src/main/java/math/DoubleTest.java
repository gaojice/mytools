package math;

import java.util.TreeSet;

public class DoubleTest {
	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<String>();
		t.add("a");
		t.add("c");
		t.add("b");
		for (String string : t) {
			System.out.println(string);
		}
	}
}
