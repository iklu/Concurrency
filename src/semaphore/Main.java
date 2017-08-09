package semaphore;

public class Main {
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore();
		
		SendingThread sender = new SendingThread(semaphore);
		ReceivingThread receiver = new ReceivingThread(semaphore);
		receiver.start();
		sender.start();
	}
}
