/**
 * @author l3m4rk
 * Created on 02.12.2021.
 */

fun main() {
    val name = "day1"
    val input = readInput(name)
    val measurements = input.map { it.toInt() }
    val result1 = countLargerMeasurements(measurements)
    println(result1)

    val result2 = countThreeMeasurementSlidingWindow(measurements)
    println(result2)
}

private fun countLargerMeasurements(measurements: List<Int>): Int {
    var count = 0
    (0..measurements.size - 2).forEach { i ->
        val current = measurements[i + 1] - measurements[i]
        if (current > 0) {
            count++
        }
    }
    return count
}

private fun countThreeMeasurementSlidingWindow(measurements: List<Int>): Int {
    val threeMeasurements = measurements.windowed(3).map { it.sum() }
    return countLargerMeasurements(threeMeasurements)
}


