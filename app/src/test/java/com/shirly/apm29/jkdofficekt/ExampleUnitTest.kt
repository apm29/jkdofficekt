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
        println(fold)
        assertEquals(4, 2 + 2)
    }
}
