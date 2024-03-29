package example;

/**
 * A class to experiment with Yeti.
 * Most methods are static, one is not (illustrateRelevantValues) and use the 'started' attribute.
 * @author Erwan Bousse
 *
 */
public class YetiExample {

	private static final String[] array = {"Red", "Blue", "Yellow", "Green"};
	private boolean started;

	public YetiExample() {
		this.started = false;
	}

	public static int illustrateExactValue(int value){
		return Integer.MAX_VALUE/(value-1337);
	}

	public static void illustrateBadConstructor(A a){
		a.useC();
	}

	public static void illustrateMissingType (Boolean bool) {
		System.out.println(bool);		
	}

	public static void illustrateUnusableConstructor(B b) {
		b.printChar();
	}


	/**
	 * Testing this method with YETI slows it down too much.
	 * Uncomment to see how YETI detects the problem.
	**/
//	public static void illustrateTimeout(A a) throws InterruptedException {
//		while (a.getInt() != 9000) {
//			a.inc();
//		}
//	}

	public static void illustrateDeclaredException() throws NullPointerException {
		Object o_null = null;
		o_null.getClass();
	}

	public static void illustrateRandomPlus(int choice) {
		switch (choice) {
		case 0: System.out.println("You made the first choice: "+array[choice]);  break;
		case 1: System.out.println("You made the second choice: "+array[choice]); break;
		case 2: System.out.println("You made the third choice: "+array[choice]); break;
		case 3: System.out.println("You made the fourth choice: "+array[choice]); break;
		case 4: System.out.println("You made the fifth choice: "+array[choice]); break;
		default:System.out.println("Please make a choice between 0 and 4");
		}
	}

	public static void illustrateAssertion(A a) {
		assert(a.getInt() > 9000);
	}

	public void illustrateRelevantValues(String command, int value){
		switch(command){
		case "print_color":	
			if (this.started) System.err.println(array[value]);
			else System.out.println("Error: not started."); break;
		case "start":
			this.started = true;
			System.out.println("Started."); break;
		case "stop":
			this.started = false;
			System.out.println("Stopped."); break;
		default:	
			System.out.println("Command not recognized");
		}
	}

}
