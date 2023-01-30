import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {

    println("Input x1:")
    var x1 = readln()?.toDoubleOrNull()
    while (x1 == null)  {
        println("Couldn't parse a number. Please, try again")
        x1 = readln()?.toDoubleOrNull()
    }

    println("Input y1:")
    var y1 = readln()?.toDoubleOrNull()
    while (y1 == null)  {
        println("Couldn't parse a number. Please, try again")
        y1 = readln()?.toDoubleOrNull()
    }

    println("Input r1:")
    var r1 = readln()?.toDoubleOrNull()
    while (r1 == null || r1 <= 0)  {
        println("Couldn't parse a number. Please, try again")
        r1 = readln()?.toDoubleOrNull()
    }

    println("Input x2:")
    var x2 = readln()?.toDoubleOrNull()
    while (x2 == null)  {
        println("Couldn't parse a number. Please, try again")
        x2 = readln()?.toDoubleOrNull()
    }

    println("Input y2:")
    var y2 = readln()?.toDoubleOrNull()
    while (y2 == null)  {
        println("Couldn't parse a number. Please, try again")
        y2 = readln()?.toDoubleOrNull()
    }

    println("Input r2:")
    var r2 = readln()?.toDoubleOrNull()
    while (r2 == null || r2 <= 0)  {
        println("Couldn't parse a number. Please, try again")
        r2 = readln()?.toDoubleOrNull()
    }

    var c1c2 = sqrt((x2 - x1).pow(2.0) + (y2 - y1).pow(2.0))

    if (x1 == x2 && y1 == y2 && r1 == r2) {
        println("Result: circles match up")
    } else if (r1 > c1c2 + r2 || r2 > c1c2 + r1) {
        println("Result: one circle is inside another")
    } else if (r1+r2 >= c1c2 || r1 == c1c2 + r2 || r2 == c1c2 + r1) {
        println("Result: the circles intersect")
    } else {
        println("Result: the circles doesn't intersect")
    }

}
