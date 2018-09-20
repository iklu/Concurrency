package thread_pool;

import java.util.ArrayList;
import java.util.List;

import blocking_queues.BlockingQueue;

/**
 * Thread Pools are useful when you need to limit the number of threads running
 * in your application at the same time. There is a performance overhead
 * associated with starting a new thread, and each thread is also allocated some
 * memory for its stack etc.
 * 
 * Instead of starting a new thread for every task to execute concurrently, the
 * task can be passed to a thread pool. As soon as the pool has any idle threads
 * the task is assigned to one of them and executed. Internally the tasks are
 * inserted into a Blocking Queue which the threads in the pool are dequeuing
 * from. When a new task is inserted into the queue one of the idle threads will
 * dequeue it successfully and execute it. The rest of the idle threads in the
 * pool will be blocked waiting to dequeue tasks.
 * 
 * Thread pools are often used in multi threaded servers. Each connection
 * arriving at the server via the network is wrapped as a task and passed on to
 * a thread pool. The threads in the thread pool will process the requests on
 * the connections concurrently. A later trail will get into detail about
 * implementing multithreaded servers in Java.
 * 
 * Java 5 comes with built in thread pools in the java.util.concurrent package,
 * so you don't have to implement your own thread pool. You can read more about
 * it in my text on the java.util.concurrent.ExecutorService. Still it can be
 * useful to know a bit about the implementation of a thread pool anyways.
 * 
 * Here is a simple thread pool implementation. Please note that this
 * implementation uses my own BlockingQueue class as explained in my Blocking
 * Queues tutorial. In a real life implementation you would probably use one of
 * Java's built-in blocking queues instead.
 * 
 * @author ovidiu.dragoi
 *
 */
public class ThreadPool {

    private BlockingQueue taskQueue = null;
    private List<PoolThread> threads = new ArrayList<PoolThread>();
    private boolean isStopped = false;

    public ThreadPool(int noOfThreads, int maxNoOfTasks){
        taskQueue = new BlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            threads.add(new PoolThread(taskQueue));
        }
        for(PoolThread thread : threads){
            thread.start();
        }
    }

    public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.enqueue(task);
    }

    public synchronized void stop(){
        this.isStopped = true;
        for(PoolThread thread : threads){
           thread.doStop();
        }
    }

}
