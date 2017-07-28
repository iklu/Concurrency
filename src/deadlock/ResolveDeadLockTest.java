package deadlock;

public class ResolveDeadLockTest {
 
    public static void main(String[] args) {
        ResolveDeadLockTest test = new ResolveDeadLockTest();
 
         A a = test.new A();
         B b = test.new B();
 
        // Thread-1
        Runnable block1 = new Runnable() {
            public void run() {
                synchronized (a) {
                    try {
                        // Adding delay so that both threads can start trying to
                        // lock resources
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // Thread-1 have A but need B also
                    synchronized (b) {
                        System.out.println("In block 1");
                    }
                }
            }
        };
 
        // Thread-2
        Runnable block2 = new Runnable() {
            public void run() {
                synchronized (b) {
                    // Thread-2 have B but need A also
                    synchronized (a) {
                        System.out.println("In block 2");
                    }
                }
            }
        };
        
        //solving the problem with "Lock Ordering":        
//        // Thread-1
//        Runnable block1 = new Runnable() {
//            public void run() {
//                synchronized (b) {
//                    try {
//                        // Adding delay so that both threads can start trying to
//                        // lock resources
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    // Thread-1 have A but need B also
//                    synchronized (a) {
//                        System.out.println("In block 1");
//                    }
//                }
//            }
//        };
//         
//        // Thread-2
//        Runnable block2 = new Runnable() {
//            public void run() {
//                synchronized (b) {
//                    // Thread-2 have B but need A also
//                    synchronized (a) {
//                        System.out.println("In block 2");
//                    }
//                }
//            }
//        };
 
        new Thread(block1).start();
        new Thread(block2).start();
    }
 
    // Resource A
    private class A {   
    }
 
    // Resource B
    private class B {      
    }
}