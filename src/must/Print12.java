package must;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author : xuan.
 * Date : 2019-08-22.
 * Description :the description of this file
 */
class Print12 {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    public static void main(String[] args) {
        Object obj = new Object();
//        new ThreadPrint(obj, "1").start();
//        new ThreadPrint(obj, "2").start();
        new ThreadA("1").start();
        new ThreadB("2").start();
    }

    public static class ThreadPrint extends Thread {
        private Object object;
        private String value;

        public ThreadPrint(Object object, String value) {
            this.object = object;
            this.value = value;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    try {
                        super.run();
                        System.out.println(value);
                        object.notifyAll();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }


    public static class ThreadA extends Thread {
        private String value;

        public ThreadA(String value) {
            this.value = value;
        }

        @Override
        public void run() {
            while (true) {

                try {
                    lock.lock();
                    System.out.println(value);
                    condition2.signal();
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }
    }

    public static class ThreadB extends Thread {
        private String value;

        public ThreadB(String value) {
            this.value = value;
        }

        @Override
        public void run() {
            while (true) {

                try {
                    lock.lock();
                    System.out.println(value);
                    condition1.signal();
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                super.run();
            }
        }
    }

}
