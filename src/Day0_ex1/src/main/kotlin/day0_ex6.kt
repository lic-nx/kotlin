fun main(args: Array<String>) {
    val start = "The program is running."
    val enterNum = "Enter a number"
    val typeEx = "or type \"exit\" to stop:"
    val boarder:Int = 1000000000
    var counter:Int = 0

    println("$start $enterNum $typeEx")
    var inputNum:String = readln()

    while (inputNum != "exit") {

        if (inputNum.toIntOrNull() == null || inputNum.toInt() < boarder * (-1) || inputNum.toInt() > boarder) {
            println("Incorrect format, try again")
        } else {
            printVal(inputNum)
        }

        counter ++
        if (counter == 5) {
            println("$enterNum $typeEx")
            counter = 0
        } else {
            println("$enterNum:")
        }
        inputNum = readlnOrNull().toString()

    }

    println("Bye!")
}

private fun printVal(inputNum: String) {

    var inputNumInt = inputNum.toInt()
    var sign = ""

    if (inputNumInt < 0) {
        sign = "minus "
        inputNumInt *= -1
    }

    val corrInputNum = inputNumInt.toString()
    val digits: Int = corrInputNum.count()
    val num = commonF(digits, corrInputNum)

    println("$sign$num ")
}

private fun defineSingleUnit(unit:Char):String {
     return when(unit) {
        '0' -> ""
        '1' -> "one "
        '2' -> "two "
        '3' -> "three "
        '4' -> "four "
        '5' -> "five "
        '6' -> "six "
        '7' -> "seven "
        '8' -> "eight "
        '9' -> "nine "
        else -> ""
    }
}

private fun defineDigits(first:Char, second:Char):String {
    var num: String = ""
    if (first == '1') {
        num = when (second) {
            '0' -> "ten "
            '1' -> "eleven "
            '2' -> "twelve "
            '3' -> "thirteen "
            '4' -> "fourteen "
            '5' -> "fifteen "
            '6' -> "sixteen "
            '7' -> "seventeen "
            '8' -> "eighteen "
            '9' -> "nineteen "
            else -> ""
        }
    } else if (first == '0') {
        num = defineSingleUnit(second)
    } else {
        num = when (first) {
            '2' -> "twenty"
            '3' -> "thirty"
            '4' -> "forty"
            '5' -> "fifty"
            '6' -> "sixty"
            '7' -> "seventy"
            '8' -> "eighty"
            '9' -> "ninety"
            else -> ""
        }
        if (second != '0') num = num.plus("-")
        num = num.plus(defineSingleUnit(second))
    }
    return num
}

private fun tripleDigits(first:Char, second:Char, third:Char): String{
    val hundred = "hundred "
    var num = "".plus(defineSingleUnit(first))
    if(first != '0'){
        num = num.plus(hundred)
    }
    num = num.plus(defineDigits(second, third))
    return num
}

private fun commonF(digits: Int, corrInputNum:String):String{
    var num = ""
    val billion = "one billion"
    val million = "million "
    val thousand = "thousand "

    if (digits == 10) {
        num = billion
    } else if (digits == 9) {
        num = num.plus(tripleDigits(corrInputNum[0], corrInputNum[1], corrInputNum[2]))
        num = num.plus(million)
        num = num.plus(tripleDigits(corrInputNum[3], corrInputNum[4], corrInputNum[5]))
        if (corrInputNum[3] != '0' || corrInputNum[4] != '0' || corrInputNum[5] != '0') {
            num = num.plus(thousand)
        }
        num = num.plus(tripleDigits(corrInputNum[6], corrInputNum[7], corrInputNum[8]))
    } else if (digits == 8) {
        num = defineDigits(corrInputNum[0], corrInputNum[1])
        num = num.plus(million).plus(tripleDigits(corrInputNum[2], corrInputNum[3], corrInputNum[4]))
        if (corrInputNum[2] != '0' || corrInputNum[3] != '0' || corrInputNum[4] != '0') {
            num = num.plus(thousand)
        }
        num = num.plus(tripleDigits(corrInputNum[5], corrInputNum[6], corrInputNum[7]))
    } else if (digits == 7) {
        num = defineSingleUnit(corrInputNum[0])
        num = num.plus(million).plus(tripleDigits(corrInputNum[1], corrInputNum[2], corrInputNum[3]))
        if (corrInputNum[1] != '0' || corrInputNum[2]!= '0' || corrInputNum[3] != '0') {
            num = num.plus(thousand)
        }
        num = num.plus(tripleDigits(corrInputNum[4], corrInputNum[5], corrInputNum[6]))
    } else if (digits == 6) {
        num = num.plus(tripleDigits(corrInputNum[0], corrInputNum[1], corrInputNum[2]))
        num = num.plus(thousand).plus(tripleDigits(corrInputNum[3], corrInputNum[4], corrInputNum[5]))
    } else if (digits == 5) {
        num = defineDigits(corrInputNum[0], corrInputNum[1])
        num = num.plus(thousand).plus(tripleDigits(corrInputNum[2], corrInputNum[3], corrInputNum[4]))
    } else if (digits == 4) {
        num = defineSingleUnit(corrInputNum[0])
        num = num.plus(thousand).plus(tripleDigits(corrInputNum[1], corrInputNum[2], corrInputNum[3]))
    } else if (digits == 3) {
        num = num.plus(tripleDigits(corrInputNum[0], corrInputNum[1], corrInputNum[2]))
    } else if (digits == 2) {
        num = defineDigits(corrInputNum[0], corrInputNum[1])
    } else if (digits == 1) {
        num = if (corrInputNum[0] == '0') {
            "zero"
        } else {
            defineSingleUnit(corrInputNum[0])
        }
    }
    return num
}
