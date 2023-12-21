package main;

public enum EnumSingleton {


    INSTANCE,
    INSTANCE2;

    static {
        Main.showTime("static block in Enum");
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

    public static EnumSingleton getInstance2() {
        return INSTANCE2;
    }

    private String info = "Enum Singleton";
    private int number = 42;

    public int getNumber() {
        return number;
    }

    public String getInfo() {
        return info;
    }

}
