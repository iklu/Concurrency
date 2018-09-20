package signaling;



public class MyWaitNotify{

	  MyWaitNotify myMonitorObject = new MyWaitNotify();

	  public void doWait(){
	    synchronized(myMonitorObject){
	      try{
	        myMonitorObject.wait();
	      } catch(InterruptedException e){
	    	  System.out.println(e);
	      }
	    }
	  }

	  public void doNotify(){
	    synchronized(myMonitorObject){
	      myMonitorObject.notify();
	    }
	  }
	}
