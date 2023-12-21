package ru.arvoglade;

/**
 * Hello world!
 *
 */
public class ThirdClass
{
    public static void main( String[] args )
    {
        run();
    }

    public static String foo() {
        return "Sup nigga!";
    }

    public static void run() {
        System.out.println("Run of third class: " + foo());
        System.out.println("\nSecond: " + SecondClass.foo());
        System.out.println("\nFirst: " + FirstClass.foo());

    }
}
