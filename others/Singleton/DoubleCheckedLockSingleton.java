package main;

public final class DoubleCheckedLockSingleton implements AbstractSingleton {
    private static volatile DoubleCheckedLockSingleton INSTANCE;

    public String info = "DoubleCheckedLockSingleton";

    private DoubleCheckedLockSingleton(){}

    // провести тесты. Не совсем понятен смысл применения localInstance
    public static DoubleCheckedLockSingleton getInstance() {
        if (INSTANCE == null) {
             synchronized (DoubleCheckedLockSingleton.class) {
                 if (INSTANCE == null) {
                     INSTANCE = new DoubleCheckedLockSingleton();
                 }
             }

        }
        return INSTANCE;
    }

    public static void drop() {
        INSTANCE = null;
    }
}
