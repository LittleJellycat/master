package basics.`var`

import java.io.File

fun main(args: Array<String>) {
    val inputData = File(args[0]).readLines().map(String::toDouble)
    println(calculateVaRHistorical(inputData))
}

fun calculateVaRHistorical(data: List<Double>, probability: Double = 0.01): Double =
    data.sorted()[(data.size * probability).toInt()]