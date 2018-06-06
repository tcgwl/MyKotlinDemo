package net.println.kotlin.network.javaandkotlin.javacode;

import net.println.kotlin.network.javaandkotlin.kotlincode.Person;

public class PersonMain {
    public static void main(String... args) {
        Person person = new Person("benny", 27);
        System.out.println(person.getName() + " is " + person.age);
        person.setName("andy");
        person.age = 26;
        System.out.println(person.getName() + " is " + person.age);
    }
}
