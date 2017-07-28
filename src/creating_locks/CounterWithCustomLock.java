package creating_locks;

public class CounterWithCustomLock {
	private Lock lock = new Lock();
	private int count = 0;

	public int inc() {
		lock.lock();
		int newCount = ++count;
		lock.unlock();
		return newCount;
	}
}
