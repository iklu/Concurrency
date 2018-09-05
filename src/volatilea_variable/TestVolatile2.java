package volatilea_variable;

/**
 * 
 * @author ovidiu.dragoi
 *
 *		Heap = main memory
 *		Thread Stack = cpu cache 
 *
 *         The Java volatile keyword is used to mark a Java variable as "being
 *         stored in main memory". More precisely that means, that every read of
 *         a volatile variable will be read from the computer's main memory, and
 *         not from the CPU cache, and that every write to a volatile variable
 *         will be written to main memory, and not just to the CPU cache.
 */
public class TestVolatile2 extends Thread {

	volatile boolean keepRunning = true;

	public void run() {
		long count = 0;
		while (keepRunning) {
			count++;
		}
		System.out.println("Thread terminated. " + count);
	}

	public static void main(String[] args) throws InterruptedException {

		// thread iteration
		TestVolatile2 t = new TestVolatile2();
		t.start();

		Thread.sleep(1000);

		// thread stop iteration
		StopRunningThread runnignIteration = new StopRunningThread(t);
		runnignIteration.start();

		System.out.println("keepRunning set to false.");
	}
}