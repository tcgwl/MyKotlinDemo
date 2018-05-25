package net.println.kotlin.chapter04.manager

/**
 * 接口代理(诸葛亮反例，事必躬亲)
 * class Manager(diver: Driver): Driver by driver
 * 接口方法实现交给代理类实现
 */
interface Driver {
    fun drive()
}

interface Writer {
    fun write()
}

class CarDriver: Driver {
    override fun drive() {
        println("开车呢")
    }

}

class PPTWriter: Writer {
    override fun write() {
        println("写PPT呢")
    }

}

class Manager: Driver, Writer {
    override fun write() {

    }

    override fun drive() {

    }

}
//资深经理
//by: 接口代理
class SeniorManager(val driver: Driver, val writer: Writer): Driver by driver, Writer by writer

//class SeniorManager(val driver: Driver, val writer: Writer): Driver, Writer {
//    override fun drive() {
//        driver.drive()
//    }
//
//    override fun write() {
//        writer.write()
//    }
//
//}

fun main(args: Array<String>) {
    val driver = CarDriver()
    val writer = PPTWriter()
    val manager = SeniorManager(driver, writer)
    manager.drive()
    manager.write()
}