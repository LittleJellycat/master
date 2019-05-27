package basics.es

fun calculateESHistorical(data: List<Double>, probability: Double = 0.025): Double =
    -data.sorted().run { take((size * probability).toInt()) }.average()