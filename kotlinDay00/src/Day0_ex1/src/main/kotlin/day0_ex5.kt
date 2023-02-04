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

    if (r1 > c1c2 + r2 || r2 > c1c2 + r1) {
        println("One circle is inside another")
    } else if (r1+r2 >= c1c2 || r1 == c1c2 + r2 || r2 == c1c2 + r1) {
        println("Result: the circles intersect")
        defineInterception(x1, y1, x2, y2, r1, r2, c1c2)
    } else {
        println("Result: the circles doesn't intersect")
    }

}

private fun defineInterception(x1:Double, y1:Double, x2:Double, y2:Double, r1:Double, r2: Double, c1c2: Double) {
    if (r1 == r2 && x1 == x2 && y1 == y2) {
        println("Окружности совпадают")
    } else {
        val a: Double = (r1.pow(2) - r2.pow(2) + c1c2.pow(2)) / (2 * c1c2)
        val h: Double = sqrt(r1.pow(2) - a.pow(2))
        val p3x: Double = x1 + a / c1c2 * (x2 - x1)
        val p3y: Double = y1 + a / c1c2 * (y2 - y1)
        val firstX1 = p3x + h / c1c2 * (y2 - y1)
        val firstY1 = p3y - h / c1c2 * (x2 - x1)
        val firstX2 = p3x - h / c1c2 * (y2 - y1)
        val firstY2 = p3y + h / c1c2 * (x2 - x1)
        if (firstX1 == firstX2 && firstY1 == firstY2) {
            println("Одно пересечение: x1 = ${"%.2f".format(firstX1)} " +
                    "y1 = ${"%.2f".format(firstY1)}")
        } else {
            println("Первое пересечение: x1 = ${"%.2f".format(firstX1)} " +
                    "y1 = ${"%.2f".format(firstY1)} , " +
                    "Второе пересечение: x2 = ${"%.2f".format(firstX2)} " +
                    "y2 = ${"%.2f".format(firstY2)}"
            )
        }
    }
}

//https://planetcalc.ru/8098/ - тут формулы