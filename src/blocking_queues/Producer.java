package blocking_queues;

public class Producer implements Runnable {

	protected BlockingQueue queue = null;

	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}

	public void run() {
		try {
			queue.enqueue("1");
			Thread.sleep(1000);
			queue.enqueue("2");
			Thread.sleep(1000);
			queue.enqueue("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}