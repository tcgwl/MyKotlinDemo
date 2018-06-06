package net.println.kotlin.network.javaandkotlin.javacode;

import net.println.kotlin.network.javaandkotlin.kotlincode.Overloads;

public class AccessToOverloads {
    public static void main(String... args) {
        Overloads overloads = new Overloads();
        overloads.overloaded(1, 2, 3);
        overloads.overloaded(1);
        overloads.overloaded(1,3);
    }
}
