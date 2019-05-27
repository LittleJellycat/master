package basics.es

import kotlin.math.pow

fun calculateWeightedEs(data: List<Double>, probability: Double = 0.025, decayFactor: Double = 0.99): Double {
    val weights = data.indices.map { decayFactor.pow(data.lastIndex - it) }
    val normFactor = weights.sum()
    val normalized = weights.map { it / normFactor }
    val sortedData = data.zip(normalized).sortedBy { it.first }
    var sum = 0.0
    var riskedSize: Int? = null
    for ((index, pair) in sortedData.withIndex()) {
        val (_, weight) = pair
        sum += weight
        if (sum >= probability) {
            riskedSize = index
            break
        }
    }
    return sortedData.take(riskedSize ?: 0)
        .run {
            if (isEmpty()) {
                Double.NaN
            } else {
                -sumByDouble { it.first * it.second } / sumByDouble { it.second }
            }
        }
}