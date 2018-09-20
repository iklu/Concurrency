package signaling;

public class MySignal {
	protected boolean hasDataToProcess = false;
	
	public synchronized void setHasDataToProcess (boolean hasData) {
		this.hasDataToProcess = hasData;
	}
	
	public synchronized boolean hasDataToProcess () {
		return hasDataToProcess;
	}
}
