package forkJoinExample;

import main.MyThread;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        Fibonachi task = new Fibonachi(10);
        pool.submit(task);
        System.out.println(task.join());
    }

    public static int fibonachiTest(int n) {
        int number = 1;
        int pastNumber = 0;
        int prepastNumber = 0;

        if (n == 0) {
            return 0;
        } else {
            for (int i = 1; i <= n; i++ ) {
                prepastNumber = pastNumber;
                pastNumber = number;
                number = prepastNumber + pastNumber;
            }
        }
        return number;
    }
}
