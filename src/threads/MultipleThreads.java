package threads;

public class MultipleThreads implements Runnable {
	
	public static int sum=0;
	public static int iterate = 0;
	
	@Override
	public void run(){
		double random = Math.random()*10;
		int y = (int) Math.round(random);
		sum += y;
		++iterate;
		System.out.println("Thread number = " +iterate+" -sum to add: "+y);
	}
}
