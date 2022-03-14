//import strings.joinToString
fun main(args: Array<String>) {

    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = hashMapOf(1 to "one", 7 to "Sevel", 44 to "Fourty Four")
    val numbers = setOf(7, 5, 1, 9, 6)
    val listStr: List<String> = listOf("Dhaka", "Bangladesh", "1200")

    println("\n\nClollection Classes in Java: \n")
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)
    println("Last Element: " + list.last())
    println("Max Number: " + numbers.maxOrNull())
    println(list + map + numbers)

    println(joinToString(list, ": ", "(", ")"))
    println("With Default Values ${joinToString(list)}")

    println("Kotlin".lastChar2())

    println("Last Word: ${listStr.last()}")
}

fun <T> joinToString(
    collection: Collection<T>, seperator: String = "; ", prefix: String = "( ", postfix: String = " )"
): String {

    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {

        if (index > 0) result.append(seperator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun String.lastChar(): Char = this.get(this.length - 1)
fun String.lastChar2(): Char = get(length - 1)