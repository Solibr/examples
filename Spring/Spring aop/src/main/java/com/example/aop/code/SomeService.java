package com.example.aop.code;

import com.example.aop.myAnnotation.Logging;
import com.example.aop.myAnnotation.Transaction;
import org.springframework.stereotype.Service;

@Service
public class SomeService {

    @Logging
    @Transaction
    public void doSomeServiceLogic() {
        System.out.println("doing some service logic...");
        //throw new RuntimeException();
    }
}
