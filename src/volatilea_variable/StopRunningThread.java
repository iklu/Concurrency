package volatilea_variable;

public class StopRunningThread extends Thread {
	
	TestVolatile2 runningIteration;
	
	StopRunningThread(TestVolatile2 runningIteration) {
		this.runningIteration = runningIteration;
	}
	
	@Override
    public void run() {
		runningIteration.keepRunning = false;
    }
}
