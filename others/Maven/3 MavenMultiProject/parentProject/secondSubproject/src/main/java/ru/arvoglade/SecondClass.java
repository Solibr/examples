package ru.arvoglade;

/**
 * Hello world!
 *
 */
public class SecondClass
{
    public static void main( String[] args )
    {
        run();
    }

    public static String foo() {
        return "Hello beatch!";
    }

    public static void run() {
        System.out.println("Run of Second class:");
        System.out.println("\tFirst: " + FirstClass.foo());
        System.out.println("\tSecond: " + foo());
    }

}
