package semaphoreExample;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public String info = "Main class";

    public static void main(String[] args) {


        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new MyThread(String.valueOf(i)));
        }

        list.forEach(Thread::start);



    }


}