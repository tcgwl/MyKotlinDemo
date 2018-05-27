package net.println.kotlin.chapter04

/**
 * 密封类
 * 1. 子类可数，枚举则是实例可数
 * - < v1.1，子类必须定义为密封类的内部类
 * - v1.1之后，子类只需要与密封类在同一个文件中
 * 2. 仔细体会与枚举的不同
 */
sealed class PlayerCmd {//可以有多个实例，而枚举实例可数
    class Play(val url: String, val position: Long = 0): PlayerCmd()

    class Seek(val position: Long): PlayerCmd()

    object Pause: PlayerCmd()

    object Resume: PlayerCmd()

    object Stop: PlayerCmd()
}

enum class PlayerState {
    IDLE, PAUSE, PLAYING
}