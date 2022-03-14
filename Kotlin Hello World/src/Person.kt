class Person(
    val name: String, var isMarried: Boolean
)

fun main(args: Array<String>) {

    val person = Person("Selise", true)
    println("Person: ${person.name} is married ${person.isMarried}")
}

