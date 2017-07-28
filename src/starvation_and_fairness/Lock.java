package starvation_and_fairness;

/**
 * A simple implementation of the Lock class could look like this:
 * 
 * 
 * f you look at the Synchronizer class above and look into this Lock
 * implementation you will notice that threads are now blocked trying to access
 * the lock() method, if more than one thread calls lock() simultanously.
 * Second, if the lock is locked, the threads are blocked in the wait() call
 * inside the while(isLocked) loop in the lock() method. Remember that a thread
 * calling wait() releases the synchronization lock on the Lock instance, so
 * threads waiting to enter lock() can now do so. The result is that multiple
 * threads can end up having called wait() inside lock().
 * 
 * If you look back at the doSynchronized() method you will notice that the
 * comment between lock() and unlock() states, that the code in between these
 * two calls take a "long" time to execute. Let us further assume that this code
 * takes long time to execute compared to entering the lock() method and calling
 * wait() because the lock is locked. This means that the majority of the time
 * waited to be able to lock the lock and enter the critical section is spent
 * waiting in the wait() call inside the lock() method, not being blocked trying
 * to enter the lock() method.
 * 
 * As stated earlier synchronized blocks makes no guarantees about what thread
 * is being granted access if more than one thread is waiting to enter. Nor does
 * wait() make any guarantees about what thread is awakened when notify() is
 * called. So, the current version of the Lock class makes no different
 * guarantees with respect to fairness than synchronized version of
 * doSynchronized(). But we can change that.
 * 
 * The current version of the Lock class calls its own wait() method. If instead
 * each thread calls wait() on a separate object, so that only one thread has
 * called wait() on each object, the Lock class can decide which of these
 * objects to call notify() on, thereby effectively selecting exactly what
 * thread to awaken.
 * 
 * @author ovidiu.dragoi
 *
 */
public class Lock {
	private boolean isLocked = false;
	private Thread lockingThread = null;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
		lockingThread = Thread.currentThread();
	}

	public synchronized void unlock() {
		if (this.lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
	}
}
