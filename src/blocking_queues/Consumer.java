package blocking_queues;

public class Consumer implements Runnable {

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}