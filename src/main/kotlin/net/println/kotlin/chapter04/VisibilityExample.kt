package net.println.kotlin.chapter04

/**
 * 可见性对比
 *
 * Kotlin:                      Java:
 * private                      private
 * protected                    protected
 * -                            default(默认，包内可见)
 * internal(模块module内可见)     -
 * public(默认)                  public
 */
class House

class Flower
//小院
class Countyard {
    private var house = House()
    var flower = Flower() //默认public
}
//紫禁城
class ForbiddenCity {
    var houses = arrayOf(House(), House())
    private var flowers = arrayOf(Flower(), Flower())
}

fun main(args: Array<String>) {
    val coutyard = Countyard()
    val forbiddenCity = ForbiddenCity()

    println(coutyard.flower)
    println(forbiddenCity.houses)
}