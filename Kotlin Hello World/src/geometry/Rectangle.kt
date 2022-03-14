package geometry

import Color
import Color.*
import Expr
import Num
import Sum
import java.util.*

class Rectangle(val height: Int, val width: Int) {

    val isSquare: Boolean get() = height == width
}

fun main(args: Array<String>) {

    val rectangle = Rectangle(10, 10)
    println("Is rectangle a square: ${rectangle.isSquare}")

    println("Creating a Random Rectangle: ${createRandomRactangle().isSquare}")
    println("Fill with RGB Color : ${Color.BLUE.rgb()}")
    println("Get Color Mnemonic : ${getColorMnemonic(RED)}")
    println("Mix Color : ${mixColor(RED, BLUE)}")
    println("Mix Color Simplified : ${mixColorSimplified(RED, GREEN)}")
    println("Eval Sum: ${eval(Sum(Num(1), Num(2)))}")
    println("Eval Num With Logging: ${eval(Num(10))}")
    println("Eval Num: ${evalWithLogging(Num(10))}")


    for (i in 100 downTo 1 step 2) {
        println(i)
    }

    //Iterating Over Map
    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {

        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }

    println("Is Character in Range Check: ${isLetter('L')}")
    println("JAVA" in "Hello JAVA") // true
    println("JAVA" in setOf("Java", "Kotlin", "JAVA"))

}


fun createRandomRactangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun getColorMnemonic(color: Color) = when (color) {
    RED -> "Richard"
    Color.GREEN -> "Gave"
    Color.BLUE -> "Battle"
}

fun mixColor(c1: Color, c2: Color) =

    when (setOf(c1, c2)) {

        setOf(RED, BLUE) -> "Orange"
        setOf(GREEN, BLUE) -> "INDIGO"
        else -> Exception("Dirty Color")
    }

fun mixColorSimplified(c1: Color, c2: Color) =

    when {
        c1 == RED && c2 == BLUE -> "Orange"
        c1 == RED && c2 == GREEN -> "INDIGO"
        else -> Exception("Dirty Color")
    }

fun eval(e: Expr): Int = if (e is Num) {
    e.value
} else if (e is Sum) {
    eval(e.right) + eval(e.right)
} else {
    throw java.lang.IllegalArgumentException("Unknown Expression")
}

fun evalWithLogging(e: Expr): Int =

    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("num: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown Exception")
    }

fun isLetter(ch:Char) = ch in 'a'..'z' || ch in 'A' .. 'K'