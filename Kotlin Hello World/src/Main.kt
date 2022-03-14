fun main(args: Array<String>) {

    val name = if (args.size > 0) args[0] else "SELISE"
    println("Name is: $name ! ${if (args.size > 0) args[0] else "someone"}")
    val num1 = 1
    var num2 = 2
    println("Finding Max Number: ${maxNumber(num1, num2)}")
    // num1 = 11 // not possible // immutable // final
    num2 = 12
    println("mAX nUM b2iN 12 & 11 IS: ${maxNum(num2, 11)}")

}

fun maxNumber(num1: Int, num2: Int): Int {
    return if (num1 > num2) num1 else num2
}

fun maxNum(val1: Int, val2: Int) = if (val1 > val2) val1 else val2

