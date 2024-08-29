class StaticBlackRunner {
	public static void main(String[] args) {
		new StaticBlock();
	}
}

public class StaticBlock {
	static {
		System.out.println("Static block");
	}

	{
		System.out.println("Instance block");
	}

	public StaticBlock() {
		System.out.println("Constructor Block");
	}
}
