package basics.`var`

import kotlin.math.pow

fun calculateWeightedVaR(data: List<Double>, decayFactor: Double = 0.99): Double {
    val weights = data.indices.map { decayFactor.pow(data.lastIndex - it) }
    val normFactor = weights.sum()
    val normalized = weights.map { it / normFactor }
    val sortedData = data.zip(normalized).sortedBy { it.first }
    var sum = 0.0
    var lastValue: Double? = null
    for ((value, weight) in sortedData) {
        sum += weight
        if (sum >= 0.01) return lastValue ?: value
        lastValue = value
    }
    return Double.NaN
}