package small_example_with_read_write;

public class Main {
	public static void main(String[] args){		
		ReadThread copyToAnother = new ReadThread();		
		WriteThread writeBack = new WriteThread();
		Thread th1 = new Thread(copyToAnother, "First thread");
		Thread th2 = new Thread(writeBack, "Second thread");
		th1.start();
		th2.start();
	}
}
