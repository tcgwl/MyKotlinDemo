package net.println.kotlin.chapter03

/**
 * 将Player.java代码复制过来，即可直接转为kotlin代码
 */
class PlayerKotlin {
    var name: String? = null
    var time: Int = 0

    internal enum class State {
        IDLE, BUFFERING, PLAYING, PAUSED
    }

    private val state = State.IDLE

    fun pause() {
        when (state) {//when替代switch
            PlayerKotlin.State.BUFFERING, PlayerKotlin.State.PLAYING -> doPause()
            else -> doOther()//什么都不做
        }
    }

    private fun doOther() {
        println("doOther")
    }

    private fun doPause() {
        println("doPause")
    }
}