package basics.`var`

import java.io.File

fun main(args: Array<String>) {
    val inputData = File(args[0]).readLines().map(String::toDouble)
    println(calculateVaRHistorical(inputData))
}

fun calculateVaRHistorical(data: List<Double>): Double = data.sorted()[data.size/100] // p ~= 0.01