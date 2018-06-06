package net.println.kotlin.network.javaandkotlin.javacode;

import net.println.kotlin.network.javaandkotlin.kotlincode.PackageKt;
//调用 kotlin 文件内的方法
public class CallPackageMethod{
    public static void main(String... args) {
        PackageKt.printlnHello();
    }
}