package net.println.kotlin.network.javaandkotlin.javacode;

import net.println.kotlin.network.javaandkotlin.kotlincode.InternalClass;

public class CallInternalClass {
    public static void main(String... args) {
        InternalClass internalClass = new InternalClass();
//        internalClass.printlnHello();//不可访问 internal 修饰的方法

//        Error:(9, 22) java: 找不到符号
//        符号:   方法 printlnHello$production_sources_for_module_MyKotlinDemo_main()
//        位置: 类型为net.println.kotlin.network.javaandkotlin.kotlincode.InternalClass的变量 internalClass
//        internalClass.printlnHello$production_sources_for_module_MyKotlinDemo_main();
    }
}
