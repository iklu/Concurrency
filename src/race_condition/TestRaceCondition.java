package race_condition;

/**
 * CRITICAL SECTION
 * Thread safe vs non-thread safe
 * 
 * @author ovidiu.dragoi
 *
 */
public class TestRaceCondition implements Runnable {
	
	//the initialized inventory variable
	private int inventory = 1;

	/**
	 * singleton demonstration
	 * @param args
	 */
	public static void main(String[] args) {
		
		//single object created
		TestRaceCondition prc = new TestRaceCondition();
		Thread firstThread = new Thread(prc, "First thread");
		Thread secondThread = new Thread(prc, "Second thread");
		firstThread.start();
		secondThread.start();
		
		System.out.println();
		
		//double object created no race condition different object resource updated
		TestRaceCondition prc1 = new TestRaceCondition();
		TestRaceCondition prc2 = new TestRaceCondition();
		Thread firstThreadPrc1 = new Thread(prc1, "First thread PRC1");
		Thread secondThreadPrc2 = new Thread(prc2, "Second thread PRC2");
		firstThreadPrc1.start();
		secondThreadPrc2.start();
	}

	public void run() {
		
		//two thread are executing the same CRITICAL SECTION but the decrement happens two times because 
		
		//synchronized (this) {
			if (inventory > 0) {
				try {
					System.out.println("Thread " + Thread.currentThread().getName() + " starting with inventory: " + inventory);
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// no op
				}
				inventory--;
				System.out.println("Thread " + Thread.currentThread().getName() + " leaving with inventory: " + inventory);
			} else { System.out.println("Need to backorder! Thread " + Thread.currentThread().getName()
						+ " found inventory with: " + inventory);
			}
		//}

	}
}
