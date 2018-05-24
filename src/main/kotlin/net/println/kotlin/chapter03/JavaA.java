package net.println.kotlin.chapter03;

public class JavaA {
    private int b;

    public int getB() {
        System.out.println("someone wants to get b.");
        return b;
    }

    public void setB(int b) {
        System.out.println("someone wants to set b.");
        this.b = b;
    }
}
