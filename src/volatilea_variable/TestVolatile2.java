package volatilea_variable;

public class TestVolatile2 extends Thread {
	
	  boolean keepRunning = true;

	    public void run() {
	        long count=0;
	        while (keepRunning) {
	            count++;
	        }

	        System.out.println("Thread terminated. "+count);
	    }

	    public static void main(String[] args) throws InterruptedException {
	        TestVolatile2 t = new TestVolatile2();
	        t.start();
	        Thread.sleep(1000);
	        
	        StopRunningThread runnignIteration = new StopRunningThread(t);
	        runnignIteration.start();
	        System.out.println("keepRunning set to false.");
	    }
	}