package starvation_and_fairness;

/**
 * To increase the fairness of waiting threads first we will change the code
 * block to be guarded by a lock rather than a synchronized block:
 * 
 * Notice how the doSynchronized() method is no longer declared synchronized.
 * Instead the critical section is guarded by the lock.lock() and lock.unlock()
 * calls.
 * 
 * @author ovidiu.dragoi
 *
 */
public class Synchronizer {
	Lock lock = new Lock();

	public void doSynchronized() throws InterruptedException {
		this.lock.lock();
		// critical section, do a lot of work which takes a long time
		this.lock.unlock();
	}
	
	public static void main(String[] args) throws InterruptedException{		
		Synchronizer sync = new Synchronizer();
		sync.doSynchronized();
	}
}
