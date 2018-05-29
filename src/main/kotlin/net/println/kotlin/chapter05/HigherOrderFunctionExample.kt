package net.println.kotlin.chapter05

/**
 * 高阶函数的基本概念
 * 1. 传入或者返回为函数的函数
 * 2. 函数引用，类似 ::println
 * 3. 带有Receiver的引用，类似 pdfPrinter::println
 */
fun main(args: Array<String>) {
    args.forEach(::println)

    val helloWorld = Hello::world

    args.filter(String::isNotEmpty).forEach(::println)//过滤空字符串，类似于这种扩展方法，有默认的第一个参数，即调用实例

    val pdfPrinter = PdfPrinter()
    args.forEach(pdfPrinter::println)
//    args.forEach(PdfPrinter::println)//错误，参数不匹配
}

class PdfPrinter {
    fun println(any: Any) {
        kotlin.io.println(any)
    }
}

class Hello {
    fun world() {
        println("HelloWorld")
    }
}