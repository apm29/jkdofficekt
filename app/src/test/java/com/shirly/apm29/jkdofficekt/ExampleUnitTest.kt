package com.shirly.apm29.jkdofficekt

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun main() {
        // a）
        A().call(E())

        // b）
        A1().call(E())

        // c）
        A().call(E())

        // d）
        A().call(E1())
    }
    @Test
    fun addition_isCorrect() {
        val list = listOf(1, 2, 3, 4, 5,7,8,9,1212,11,131,4)
        val fold = list
                .filter {
                    it > 3
                }
                .also {
                    println(it.count())
                }
                .map {
                    return@map it%100
                }
                .map {
                    println("in map = [$it]")
                    it
                }
                .dropLastWhile {
                    it>10
                }
                .dropWhile {
                    it == 7
                }
                .fold(

                        initial = 0,
                        operation = { a, b ->
                            println("a = [$a], b = [$b]")
                            return@fold a + b
                        }
                )
        val array = arrayOf(1,3,12,23,34,1214,21)
        val arrayList = arrayListOf<Int>(1,12,23,123)
        println(fold)
        assertEquals(4, 2 + 2)
    }
}
interface S{
    val s:Int
    fun foo(): Unit {
        println()
    }
}

sealed class SealClass:S{
    override val s: Int
        get() = 3
    init {
        val c1 = C1()
        when(c1::class){
            C1::class-> println()
            C2::class-> println()
            C3::class-> println()
            C4::class-> println()
            else-> println("else")
        }
        AA.a
        AA.foo()
    }
    class C1:SealClass()
    class C2:SealClass()
    class C3:SealClass()
    class C4:SealClass()
}

object AA{
    var a: Nothing? = null
    init {
        val c1 = SealClass.C1()
        when(c1::class){
            c1::class-> println()
            SealClass.C2::class-> println()
            SealClass.C3::class-> println()
            SealClass.C4::class-> println()
            else-> println("else")
        }
    }

    fun foo(): Unit {
        println()
    }
}

open class E {

}

open class E1: E() {

}

open class A {

    open fun E.f() {
        println("E.f in A")
    }

    open fun E1.f() {
        println("E1.f in A")
    }

    fun call(e: E) {
        e.f()
    }
}

class A1: A() {

    override fun E.f() {
        println("E.f in A1")
    }

    override fun E1.f() {
        println("E1.f in A1")
    }
}

