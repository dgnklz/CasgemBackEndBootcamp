package test;

public class Main {
	
	interface FunctionalInterface {
		void run();
	}
	
	
	public static void main(String[] args) {
		
		FunctionalInterface functionalInterface = () -> System.out.println("Running");
		
		functionalInterface.run();
		
		
	}

}




