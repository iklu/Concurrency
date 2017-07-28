package creating_locks;

public class CounterWithSynchronized {

	private int count = 0;

	public int inc() {
		synchronized (this) {
			return ++count;
		}
	}
}
