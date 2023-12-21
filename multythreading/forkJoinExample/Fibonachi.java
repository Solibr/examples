package forkJoinExample;

import java.util.concurrent.RecursiveTask;

public class Fibonachi extends RecursiveTask<Integer> {
    private int n;

    public Fibonachi(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {

        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        Fibonachi f1 = new Fibonachi(n - 1);
        Fibonachi f2 = new Fibonachi(n - 2);
        f1.fork();
        f2.fork();
        return f1.join() + f2.join();
    }
}
