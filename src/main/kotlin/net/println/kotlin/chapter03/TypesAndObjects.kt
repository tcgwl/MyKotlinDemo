package net.println.kotlin.chapter03

class 美女(性格:String, 长相:String, 声音:String): 人(性格, 长相, 声音)
class 帅哥(性格:String, 长相:String, 声音:String): 人(性格, 长相, 声音)

open class 人(性格:String, 长相:String, 声音:String) {
    init {
        println("new 了一个人, ${this.javaClass.simpleName} ta 性格:$性格, 长相:$长相, 声音:$声音")
    }

    fun 唱歌(歌名: String) {
        println("${this.javaClass.simpleName}正在唱歌: $歌名")
    }
    fun 跳舞(舞蹈名: String) {
        println("${this.javaClass.simpleName}正在跳舞: $舞蹈名")
    }
}

fun main(args: Array<String>) {
    val 赵丽颖 = 美女("温柔", "甜美", "动听")
    val 胡歌 = 帅哥("开朗", "俊俏", "豪放")

    赵丽颖.唱歌("十年")
    赵丽颖.跳舞("天鹅湖")

    胡歌.唱歌("六月的雨")
    胡歌.跳舞("仙剑")

}