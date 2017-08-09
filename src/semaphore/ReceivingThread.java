package semaphore;

public class ReceivingThread extends Thread {
	Semaphore semaphore = null;
	public ReceivingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			
			//put on red
			this.semaphore.release();
			
			
			// receive signal, then do something...
			System.out.println("is green starting..");
		} catch (InterruptedException e) {

		}
	}
}
