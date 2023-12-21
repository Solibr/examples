package org.example;



public class MavenMultiModuleSpringApplication {
    public static void main(String[] args) {
        System.out.println("Hello world");

        Module module = new Module1();
        System.out.println(module.getName());

    }

    private static class Module1 implements Module {

        @Override
        public String getName() {
            return "inner module";
        }
    }

}
