package signaling;

public class Main {

	protected MySignal sharedSignal;

	public static void main(String[] args) {
		
		Main m = new Main();
		while (!m.sharedSignal.hasDataToProcess()) {
			// do nothing... busy waiting
		}

	}

}
