package net.println.kotlin.chapter03

fun main(args: Array<String>) {
    for (arg in args) {
        println(arg)
    }

    for ((index, value) in args.withIndex()) {
        println("$index->$value")
    }
    //上面等价于
    for (indexedValue in args.withIndex()) {
        println("${indexedValue.index}->${indexedValue.value}")
    }

    val myList = MyIntList()
    myList.add(1).add(2).add(3)
    for (i in myList) {
        println(i)
    }
}

class MyIterator(val iterator: Iterator<Int>) {
    operator fun next(): Int {
        return iterator.next()
    }

    operator fun hasNext(): Boolean {
        return iterator.hasNext()
    }
}
//演示自定义类型的迭代
class MyIntList {
    private val list = ArrayList<Int>()

    fun add(int: Int): MyIntList {
        list.add(int)
        return this
    }

    fun remove(int: Int) {
        list.remove(int)
    }

    operator fun iterator(): MyIterator {
        return MyIterator(list.iterator())
    }
}