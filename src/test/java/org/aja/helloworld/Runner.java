package org.aja.helloworld;

public class Runner {

    public static void main(String...args) {
        new Runner().init();
    }

    private void init() {
        String name = "hanna";

        System.out.println(name);
        System.out.println(name.toUpperCase());
    }
}
