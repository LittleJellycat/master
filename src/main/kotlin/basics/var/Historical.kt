package basics.`var`

fun calculateVaRHistorical(data: List<Double>, probability: Double = 0.01): Double =
    -data.sorted()[(data.size * probability).toInt()]