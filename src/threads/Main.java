package threads;

/**
 * Created by ovidiu on 22.03.2017. 1.Create a simple counting thread. It will
 * count from start to end with a certain step.
 * 
 * Create 3 instances of the thread, that will count from 1 to 100 with the
 * following steps: 2, 3 and 5. Set a name for each thread and when printing the
 * numbers, print also the name of the thread. 
 * 
 * 2. Write a program that runs 5
 * threads, each thread randomizes a number between 1 and 10. The main thread
 * waits for all the others to finish, calculates the sum of the numbers which
 * were randomized and prints that sum. You will need to implement a Runnable
 * class that randomizes a number and store it in a member field. When all the
 * threads have done, your main program can go over all the objects and check
 * the stored values in each object.
 * 
 * 3.(optional) Modify the program in (1) so that instead of each object keeping
 * its own score, you will use one collection to store all the results in.
 * 
 * 
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {
		// first thread
		CountingThread firstThread = new CountingThread(2, "First Thread");
		firstThread.start();

		// second thread
		CountingThread secondThread = new CountingThread(3, "Second Thread");
		secondThread.start();

		// third thread
		CountingThread thirdThread = new CountingThread(5, "Third Thread");
		thirdThread.start();

		int iterate = 0;
		// async
		while (iterate < 200) {
			MultipleThreads multipleThreads = new MultipleThreads();
			Thread thread = new Thread(multipleThreads);
			thread.start();
			thread.join();
			++iterate;
		}

		System.out.println("\n The sum is:" + MultipleThreads.sum);
		MultipleThreads.sum = 0;
	}
}
