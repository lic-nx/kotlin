fun main(args: Array<String>) {

    val mode = if (args.isNotEmpty()) {
        Mode.values().find { modeName ->
            modeName.name.equals(args[0], true)
        } ?: Mode.Celsius
    } else Mode.Celsius

    println("Output mode: $mode")
    println("Enter a season - (W)inter or (S)ummer:")

    var season = readlnOrNull()?.toSeason()
    while (season == null) {
        println("Incorrect input. Enter a season:")
        season = readlnOrNull()?.toSeason()
    }

    println("Enter a temperature:")
    var temperature = readlnOrNull()?.toDoubleOrNull()
    while (temperature == null || temperature > 70.0 || temperature < -70.0) {
        println("Incorrect input. Enter a temperature:")
        temperature = readlnOrNull()?.toDoubleOrNull()
    }

    val currentTemperature = temperatureValue(mode, temperature)
    println("The temperature is $currentTemperature ${mode.shortName}")
    comfortableTemperature(mode, season, currentTemperature)

}

private fun String.toSeason(): Season? = Season.values().find {
    it.shortName.equals(this, true)
}

enum class Mode(val shortName: String) {
    Kelvin("K"), Celsius("˚C"), Fahrenheit("˚F")
}

enum class Season(val shortName: String) {
    WINTER("W"), SUMMER("S")
}


private fun temperatureValue(mode: Mode, value: Double): Double {
    val temperature: Double = when (mode) {
        Mode.Kelvin -> value + 273.15
        Mode.Fahrenheit -> 9.0 / 5.0 * value + 32.0
        else -> value
    }
    return temperature;
}

private fun comfortableTemperature(mode: Mode, season: Season, value: Double) {
    var lower: Double = 0.0
    var upper: Double = 0.0
    when (season) {
        Season.WINTER -> {
            lower = temperatureValue(mode, 20.0)
            upper = temperatureValue(mode, 22.0)
        }

        Season.SUMMER -> {
            lower = temperatureValue(mode, 22.0)
            upper = temperatureValue(mode, 25.0)
        }

    }

    println("The comfortable temperature is from $lower to $upper ${mode.shortName}.")
    if (value < lower) {
        println("Please, make it warmer by ${"%.2f".format(lower - value)} degrees.")
    } else if (value > upper) {
        println("Please, make it warmer by ${"%.2f".format(upper - value)} degrees.")
    } else {
        println("Comfortable temperature")
    }
}