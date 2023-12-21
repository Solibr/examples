package semaphoreExample;

import java.util.concurrent.Semaphore;

public class MyThread extends Thread {

    public static Semaphore semaphore = new Semaphore(2);

    public static void print() {
        try {
            semaphore.acquire();
            for(int i = 0; i < 10; i++) {
                System.out.print(Thread.currentThread().getName());
                //try {
                    Thread.sleep(500);
                /*} catch (InterruptedException e) {

                }*/
            }
        } catch (InterruptedException e) {}
        finally {
            semaphore.release();
        }

    }

    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        print();
    }
}
