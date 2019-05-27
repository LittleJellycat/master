import basics.`var`.calculateHistoricalBasedMonteCarloVaR
import basics.`var`.calculateVaRHistorical
import basics.`var`.calculateWeightedVaR
import basics.es.calculateESHistorical
import basics.es.calculateHistoricalBasedMonteCarloES
import basics.es.calculateWeightedEs
import java.io.File

fun main(args: Array<String>) {
    val data = File(args.first())
        .readLines().drop(1)
        .map { it.split(',') }
        .map { (_, _, _, _, close) -> close.toDouble() }
        .zipWithNext { previous, current -> (current - previous) / previous }

    val historicalVaR = calculateVaRHistorical(data)
    val monteCarloVaR = calculateHistoricalBasedMonteCarloVaR(data)
    val weightedVaR = calculateWeightedVaR(data)

    val historicalEs = calculateESHistorical(data)
    val monteCarloEs = calculateHistoricalBasedMonteCarloES(data)
    val weightedEs = calculateWeightedEs(data)

    println(
        """
        |historicalVaR = $historicalVaR
        |monteCarloVaR = $monteCarloVaR
        |weightedVaR = $weightedVaR
        |
        |historicalEs = $historicalEs
        |monteCarloEs = $monteCarloEs
        |weightedEs = $weightedEs""".trimMargin()
    )
}