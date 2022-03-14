@file:JvmName("StringFunctions")

package strings

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

fun main(args: Array<String>) {
    println("")
}