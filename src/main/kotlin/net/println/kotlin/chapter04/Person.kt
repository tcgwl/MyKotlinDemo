package net.println.kotlin.chapter04
//抽象类与继承
abstract class Person(open val age: Int) {
    abstract fun work()
}

class MaNong(age: Int): Person(age) {
    override val age: Int
        get() = 0

    override fun work() {
        println("我是码农，我在编写代码。")
    }

}

class Doctor(age: Int): Person(age) {
    override fun work() {
        println("我是医生，我在给病人看病。")
    }

}

fun main(args: Array<String>) {
    val person: Person = MaNong(23)
    person.work()
    println(person.age) //0

    val person2: Person = Doctor(27)
    person2.work()
    println(person2.age) //27
}