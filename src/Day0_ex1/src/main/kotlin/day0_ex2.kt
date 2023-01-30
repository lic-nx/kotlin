import kotlin.math.pow
fun main(args: Array<String>) {
    val grouping: Grouping = if (args.isNotEmpty()) {
        Grouping.values().find { groupName ->
            groupName.name.equals(args[0], true)
        } ?: Grouping.Lower
    } else Grouping.Lower

    println("The grouping order is: ${grouping.shortName}")
    println("Enter a number:")
    var number:Int
    try {
        number = readln().toInt()
    } catch (e : NumberFormatException ) {
        throw Exception("Wrong input")
    }

    if(number < 0 ) {
        number *= (-1)
    }

    val digits: Int = number.toString().count()

    if(grouping == Grouping.Lower) {
        number = number.toString().reversed().toInt()
    }

    for(i in (digits - 1) downTo 0) {
        val createdNumber = number / 10.toDouble().pow(i).toInt()

        if (isPrimeNumber(createdNumber) && createdNumber != 0) {
            println("$createdNumber - prime")
        } else {
            println("$createdNumber")
        }
    }

}
enum class Grouping(val shortName: String) {
    Lower("lower"), Upper("upper")
}

private fun isPrimeNumber(number:Int): Boolean {
    for (i in 2..number/2) {
        if (number % i == 0) {
            return false
        }
    }
    return true
}