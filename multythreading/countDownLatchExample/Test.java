package countDownLatchExample;

import main.MyThread;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class Test {
    public static int threadsCount = 4 * Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(threadsCount);
        ArrayList<Thread> list = new ArrayList<>();
        for (int i = 0; i < threadsCount; i++) {
            list.add(new MyThread(String.valueOf(i), latch));
        }
        list.forEach(Thread::start);
    }

    public static class MyThread extends Thread {
        private CountDownLatch latch;

        public MyThread(String name, CountDownLatch latch) {
            setName(name);
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep((long)(10000 * Math.random()));
                System.out.println("Preparation done. Thread " + getName());
                latch.countDown();
                latch.await();

            } catch (InterruptedException e) {}
            System.out.println("Begin computation " + getName());

        }
    }

    //public  ;
}
