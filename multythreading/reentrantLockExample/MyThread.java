package reentrantLockExample;

import static reentrantLockExample.Test.*;

public class MyThread extends Thread {
    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {

        if (testNumber == 2) {
            try {
                if (allowLocking)
                    lock.lock();
                secondFoo(firstFoo());
            } finally {
                if (allowLocking)
                    lock.unlock();
            }
        }

        if (testNumber == 1)
        secondFoo(firstFoo());

    }
}
