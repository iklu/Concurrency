package blocking_queues;

public class Main {
	public static void main(String[] args) throws InterruptedException{
		BlockingQueue queue = new BlockingQueue(1);
		
		   	Producer producer = new Producer(queue);
	        Consumer consumer = new Consumer(queue);

	        new Thread(producer).start();
	        new Thread(consumer).start();

	        Thread.sleep(4000);
	}
}
