package net.println.kotlin.chapter04;

public class StaticJava {
    public static void main(String...args) {
        Latitude latitude = Latitude.Companion.ofDouble(3.0);
        latitude = Latitude.ofDouble(3.0);//在java中访问需要添加@JvmStatic
        System.out.println(Latitude.TAG);//在java中访问需要添加@JvmField
    }
}
