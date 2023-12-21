package main;

public final class Singleton implements AbstractSingleton {
    private static Singleton INSTANCE;

    public String info = "Singleton";

    private Singleton(){}

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    public static void drop() {
        INSTANCE = null;
    }
}
