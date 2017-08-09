package semaphore;

public class SendingThread extends Thread {
	Semaphore semaphore = null;

	public SendingThread(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		
		System.out.println("Passing other...");
		// do something, then signal
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}

		//put on green
		this.semaphore.take();
	}
}
