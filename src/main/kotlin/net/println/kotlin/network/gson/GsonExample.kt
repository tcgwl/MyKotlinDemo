package net.println.kotlin.network.gson

import com.google.gson.Gson
import java.io.File

/**
 * java 中的泛型是伪泛型，采用了类型擦除的机制来实现泛型。
 * 泛型只有在编译期存在，在运行期并没有泛型的信息。
 *
 *              C#          Kotlin/Java
 * 编译前   List<String>    List<String>
 * 编译后   List<String>    List
 */
fun main(args: Array<String>) {
    val json = File("singer.json").readText()
//    val result = Gson().fromJson(json, Singer::class.java)
    val result: Singer = Gson().fromJson(json)
    println(result)
}

/**
 * 以下代码会报错
 * 调用了带有 reified 的方法，它的调用者不能含有泛型
 */
//fun <T: Any> getResult(json:String): T {
//    return Gson().fromJson(json)
//}