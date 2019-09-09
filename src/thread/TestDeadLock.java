package thread;

public class TestDeadLock extends Thread {

    boolean b;
    DeadLock deadLock;
    public TestDeadLock(boolean b, DeadLock deadLock) {
        super();
        this.b = b;
        this.deadLock = deadLock;
    }

    public static void main(String[] args) {
        DeadLock lock = new DeadLock();
        TestDeadLock t1 = new TestDeadLock(true, lock);
        TestDeadLock t2 = new TestDeadLock(false, lock);
        t1.start();
        t2.start();
    }


    @Override
    public void run() {
        if(b) {
            deadLock.m1();
        } else {
            deadLock.m2();
        }
    }

    public static class DeadLock {
        Object o1 = new Object();
        Object o2 = new Object();

        public void m1() {
            synchronized(o1) {
                System.out.println("m1 lock o1 first");
                synchronized(o2) {
                    System.out.println("m1 lock o2 second");
                }
            }
        }

        public void m2() {
            synchronized(o2) {
                System.out.println("m2 lock o2 first");
                synchronized (o1) {
                    System.out.println("m2 lock o1 second");
                }
            }
        }
    }
}
