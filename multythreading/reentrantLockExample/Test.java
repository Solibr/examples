package reentrantLockExample;

import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// TODO можно ли поместить блокировки в метод run в классе MyThread?
public class Test {

    // === Уравление ===
    public static final boolean allowLocking = true;
    public static final byte testNumber = 1;
    // =================

    private static int number = 0;
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) {

        if (testNumber != 1 && testNumber != 2)
            throw new IllegalArgumentException("Incorrect test number. Could by only 1 or 2");

        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyThread(String.valueOf(i)));
        }
        list.forEach(Thread::start);

    }

    /**
     * в этом тесте конечный результат должен быть 10,
     * но без блокировок может получиться непоследовательный результат меньше 10.
     * Демонстрирует блокировку и разблокировку в разных методах
     */
    public static void test1() {

    }

    // Рекомендуемое применение с finally, чтобы избежать вечной блокировки
    public static void test2() {
        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyThread(String.valueOf(i)));
        }
        list.forEach(Thread::start);

        /*try {
            lock.lock();
            secondFoo(firstFoo());
        } finally {
            lock.unlock();
        }*/
    }

    public static String firstFoo() {

        if (condition()) {
            lock.lock();
        }

        int number = Test.number;

        // секция для замедления метода
        double sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum = Math.random() * Math.random();
        }
        // конце секции

        number++;
        Test.number = number;
        return String.valueOf(number);
    }

    public static void secondFoo(String number) {
        System.out.println(number);

        if (condition()) {
            lock.unlock();
        }
    }

    public static boolean condition() {
        return allowLocking && testNumber == 1;
    }

}
