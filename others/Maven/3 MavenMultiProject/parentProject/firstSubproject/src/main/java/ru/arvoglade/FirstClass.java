package ru.arvoglade;

/**
 * Hello world!
 *
 */
public class FirstClass
{
    public static void main( String[] args )
    {
        run();
    }

    public static String foo() {
        return "Hello from first subproject!";
    }

    public static void run() {
        System.out.println("Run of first class: " + foo());
    }

}
