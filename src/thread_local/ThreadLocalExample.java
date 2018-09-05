package thread_local;

/**
 * The ThreadLocal class in Java enables you to create variables that can only
 * be read and written by the same thread. Thus, even if two threads are
 * executing the same code, and the code has a reference to a ThreadLocal
 * variable, then the two threads cannot see each other's ThreadLocal variables.
 * 
 * if the property is initialized as a class member the threads shares the same object in heap memory
 * if the variable is initialized in method then stack memory (Local variable)
 * 
 * to use class member initialized different object then ThreadLocal
 * 
 * @author ovidiu.dragoi
 *
 */
public class ThreadLocalExample {

	public static class Calculate implements Runnable {	

        public ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100D));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

			}

			System.out.println(threadLocal.get());
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Calculate sharedRunnableInstance = new Calculate();

		Thread thread1 = new Thread(sharedRunnableInstance);
		Thread thread2 = new Thread(sharedRunnableInstance);

		thread1.start();
		thread2.start();

		thread1.join(); // wait for thread 1 to terminate
		thread2.join(); // wait for thread 2 to terminate
	}
}
