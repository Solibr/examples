package main;

public final class EarlyInitializingSingleton implements AbstractSingleton {
    private static EarlyInitializingSingleton INSTANCE = new EarlyInitializingSingleton();

    public String info = "EarlyInitializingSingleton";

    static {
        Main.showTime("static block in EarlyInitSingleton");
    }

    private EarlyInitializingSingleton() {}

    public static EarlyInitializingSingleton getInstance() {
        return INSTANCE;
    }
}
