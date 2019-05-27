package basics.es

fun calculateHistoricalBasedMonteCarloES(data: List<Double>): Double =
    calculateGeneratorBasedMonteCarloES { data.random() }

fun calculateGeneratorBasedMonteCarloES(
    sampleSize: Int = 365,
    probability: Double = 0.025,
    generator: () -> Double
): Double =
    -generateSequence(generator)
        .take(sampleSize)
        .sorted()
        .toList().run { take((size * probability).toInt()) }.average()