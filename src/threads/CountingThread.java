package threads;

public class CountingThread extends Thread{
	private int number;
	private String thread;
	
	public CountingThread(int number, String thread){
		super();
		this.number = number;
		this.thread = thread;
	}
	
	public void run() {
		for(int i = number; i<50; i++) {
			System.out.println(thread+": "+i);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
