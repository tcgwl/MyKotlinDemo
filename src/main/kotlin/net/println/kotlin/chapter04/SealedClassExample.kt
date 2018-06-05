package net.println.kotlin.chapter04

import kotlin.properties.Delegates

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
    IDLE, PAUSED, PLAYING
}

class Player {
    //通过observable捕获state，并且通知给后面的lambda函数
    private var state: PlayerState by Delegates.observable(PlayerState.IDLE, {prop, oldValue, newValue ->
        println("$oldValue -> $newValue")
        onPlayerStateChangedListener?.onStateChanged(oldValue, newValue)
    })

    private fun sendCmd(cmd: PlayerCmd) {
        when(cmd) {
            is PlayerCmd.Play -> {
                println("\nPlay ${cmd.url} from ${cmd.position}ms")
                state = PlayerState.PLAYING
                doPlay(cmd.url, cmd.position)
            }
            is PlayerCmd.Pause -> {
                println("\nPause.")
                state = PlayerState.PAUSED
                doPause()
            }
            is PlayerCmd.Resume -> {
                println("\nResume.")
                state = PlayerState.PLAYING
                doResume()
            }
            is PlayerCmd.Stop -> {
                println("\nStop.")
                state = PlayerState.IDLE
                doStop()
            }
            is PlayerCmd.Seek -> {
                println("\nSeek to ${cmd.position}ms, state: $state")
                doSeek(cmd.position)
            }
        }
    }

    private fun doPlay(url: String, position: Long) {

    }

    private fun doSeek(position: Long) {

    }

    private fun doPause() {

    }

    private fun doResume() {

    }

    private fun doStop() {

    }

    interface OnPlayerStateChangedListener {
        fun onStateChanged(oldState: PlayerState, newState: PlayerState)
    }

    var onPlayerStateChangedListener: OnPlayerStateChangedListener? = null

    fun play(url: String, position: Long = 0) {
        sendCmd(PlayerCmd.Play(url, position))
    }

    fun seekTo(position: Long) {
        sendCmd(PlayerCmd.Seek(position))
    }

    fun pause() {
        sendCmd(PlayerCmd.Pause)
    }

    fun resume() {
        sendCmd(PlayerCmd.Resume)
    }

    fun stop() {
        sendCmd(PlayerCmd.Stop)
    }
}

fun main(args: Array<String>) {
    val player = Player()
    player.play("http://abc.mp3")
    player.pause()
    player.resume()
    player.seekTo(30000)
    player.stop()

}