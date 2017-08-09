package creating_locks;

public class CounterWithCustomLock {
	private Lock lock = new Lock();
	private int count = 0;

	public int inc()  throws InterruptedException {
		lock.lock();
	      //critical section, do a lot of work which takes a long time
		int newCount = ++count;
		lock.unlock();
		return newCount;
	}
}
