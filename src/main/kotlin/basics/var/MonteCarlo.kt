package basics.`var`

fun main() {

}

fun calculateHistoricalBasedMonteCarloVaR(data: List<Double>): Double =
    calculateGeneratorBasedMonteCarloVaR { data.random() }

fun calculateGeneratorBasedMonteCarloVaR(sampleSize: Int = 365, generator: () -> Double): Double =
    generateSequence(generator).take(sampleSize).sorted().toList()[sampleSize / 100]