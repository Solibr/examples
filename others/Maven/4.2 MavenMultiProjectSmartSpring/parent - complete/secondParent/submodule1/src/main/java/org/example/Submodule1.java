package org.example;

import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class Submodule1 implements Module {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    @Override
    public String getName() {
        return "Submodule!";
    }
}
