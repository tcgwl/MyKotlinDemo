package net.println.kotlin.chapter04

import java.lang.IllegalArgumentException

/**
 * 抽象类与接口(半成品与协议)
 *
 * 接口，直观理解就是一种约定
 * 不能有状态
 * 必须由类对其进行实现后使用
 *
 * 抽象类
 * 实现了部分协议的半成品
 * 可以有状态，可以有方法实现
 * 必须由子类继承后使用
 *
 * 抽象类与接口的共性
 * 1.比较抽象，不能直接实例化
 * 2.有需要子类(实现类)实现的方法
 * 3.父类(接口)变量可以接受子类(实现类)的实例赋值
 *
 * 抽象类与接口的区别
 * 1.抽象类有状态，接口无状态
 * 2.抽象类有方法实现，接口只能有无状态的默认实现
 * 3.抽象类只能单继承，接口可以多实现
 * 4.抽象类反映本质，接口体现能力(从设计思想角度考虑)
 *
 * 直接的说，如果用抽象类与接口来描述一个东西，
 * 那么这个东西的中心词前面的修饰词就是接口要负责的部分，
 * 中心词就是抽象类要负责的部分。
 * 例如：<联想><笔记本>电脑
 * 用'联想'和'笔记本'分别做一个接口，'电脑'做一个抽象父类
 */

//输入设备接口
interface InputDevice {
    fun input(event: Any)
}
//usb接口
interface USBInputDevice: InputDevice
//蓝牙
interface BLEInputDevice: InputDevice

abstract class USBMouse(val name: String): USBInputDevice, OpticalMouse {
    override fun input(event: Any) {

    }

    override fun toString(): String {
        return name
    }
}

class LogitechMouse: USBMouse("罗技鼠标")

//光电鼠标
interface OpticalMouse

class Computer {
    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("add usb input device: $inputDevice")
    }
    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("add ble input device: $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when(inputDevice) {
            is USBInputDevice -> addUSBInputDevice(inputDevice)
            is BLEInputDevice -> addBLEInputDevice(inputDevice)
            else -> throw IllegalArgumentException("输入设备类型不支持")
        }
    }
}

fun main(args: Array<String>) {
    val computer = Computer()
//    val mouse = USBMouse("罗技鼠标")
    val mouse = LogitechMouse()
    computer.addInputDevice(mouse) //add usb input device: 罗技鼠标
}
