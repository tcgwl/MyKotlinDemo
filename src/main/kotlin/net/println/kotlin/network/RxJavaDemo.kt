package net.println.kotlin.network

import rx.Observable
import java.io.File
import java.util.concurrent.Executors

/**
 * java的方法中如果传参是一个接口，并且接口中只有一个方法，那么可以用lambda表达式替代，例如下面示例中的filter/groupBy/map/execute等，
 * 如果是kotlin则不可以如此。
 */
fun main(args: Array<String>) {
    val text = File(ClassLoader.getSystemResource("input").path).readText()
    Observable.from(text.toCharArray().asIterable()).filter { !it.isWhitespace() }.groupBy { it }.map{
        //groupBy返回的是Observable
        o -> o.count().subscribe{
            println("${o.key} -> $it")
        }
    }.subscribe()

    val worker = Executors.newCachedThreadPool()
    worker.execute {
        println("Hello")
    }
}