class Counter {
	private final int count = 0;
	// private int count = 0;

	public Counter() {
		// count++;
		System.out.println(count);
	}
}

public class Main {
	public static void main(String[] args) {
		Counter counter1 = new Counter();
		Counter counter2 = new Counter();
	}
}