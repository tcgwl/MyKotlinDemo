package net.println.kotlin.network.gson

import com.google.gson.Gson

/**
 * 用 reified，告别 class
 * 其实加上 reified 关键字之后，T就可以像一个真实类型一样去使用
 * inline 关键字：要求代码真正的编译到了调用点，类型都是确定的
 */
inline fun <reified T: Any> Gson.fromJson(json:String): T {
    return fromJson(json, T::class.java)
}