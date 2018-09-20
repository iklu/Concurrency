package thread_pool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * The thread pool implementation consists of two parts. A ThreadPool class
 * which is the public interface to the thread pool, and a PoolThread class
 * which implements the threads that execute the tasks.
 * 
 * To execute a task the method ThreadPool.execute(Runnable r) is called with a
 * Runnable implementation as parameter. The Runnable is enqueued in the
 * blocking queue internally, waiting to be dequeued.
 * 
 * The Runnable will be dequeued by an idle PoolThread and executed. You can see
 * this in the PoolThread.run() method. After execution the PoolThread loops and
 * tries to dequeue a task again, until stopped.
 * 
 * To stop the ThreadPool the method ThreadPool.stop() is called. The stop
 * called is noted internally in the isStopped member. Then each thread in the
 * pool is stopped by calling doStop() on each thread. Notice how the execute()
 * method will throw an IllegalStateException if execute() is called after
 * stop() has been called.
 * 
 * The threads will stop after finishing any task they are currently executing.
 * Notice the this.interrupt() call in PoolThread.doStop(). This makes sure that
 * a thread blocked in a wait() call inside the taskQueue.dequeue() call breaks
 * out of the wait() call, and leaves the dequeue() method call with an
 * InterruptedException thrown. This exception is caught in the PoolThread.run()
 * method, reported, and then the isStopped variable is checked. Since isStopped
 * is now true, the PoolThread.run() will exit and the thread dies.
 * 
 * @author ovidiu.dragoi
 *
 */
public class Main {
	
	public class Device {
		public String IP;
		public int port;
		
		public Device(String IP, int port) {
			this.IP = IP;
			this.port = port;
		}

		@Override
		public String toString() {
			return "Device [IP=" + IP + ", port=" + port + "]";
		}
		
		
	}
	
	public class DeviceRegistry {
		Set<Device> devices = new HashSet<>();
		public void addDevice(Device device) {
			devices.add(device);
		}
		
		public Set<Device> getDevices() {
			return devices;
		}
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		
		Main main = new Main();		

		DeviceRegistry registry = main.new DeviceRegistry();
		
		registry.addDevice(main.new Device("192.167.153.1", 4060));
		registry.addDevice(main.new Device("192.167.153.2", 4050));
		registry.addDevice(main.new Device("192.167.153.3", 4030));
		registry.addDevice(main.new Device("192.167.153.4", 4080));
		
		ThreadPool threadPool = new ThreadPool(6, 4);
		
		for (Device d: registry.getDevices()) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println( d.toString() + " " + Thread.currentThread().getName());
				}
			});
		}
		
		
		


		
		System.out.println("thread running");
		threadPool.stop();

	}
	
	

}
