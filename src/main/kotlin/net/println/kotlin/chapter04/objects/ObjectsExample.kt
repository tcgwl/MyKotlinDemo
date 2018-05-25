package net.println.kotlin.chapter04.objects

class Driver

interface OnExtenalDriverMountListener {
    fun onMount(driver: Driver)
    fun onUnMount(driver: Driver)
}

abstract class Player {
    abstract fun play()
    abstract fun pause()
    abstract fun stop()
}

/**
 * object
 * 1. 只有一个实例的类
 * 2. 不能自定义构造方法
 * 3. 可以实现接口、继承父类
 * 4. 本质上就是单例模式最基本的实现
 */
object MusicPlayer: Player(), OnExtenalDriverMountListener {
    val state: Int = 0

    override fun play() {
    }

    override fun pause() {
    }

    override fun stop() {
    }

    override fun onMount(driver: Driver) {
        println("onMount")
    }

    override fun onUnMount(driver: Driver) {
        println("onUnMount")
    }

}

