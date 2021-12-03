/**
 * @author l3m4rk
 * Created on 04.12.2021.
 */

fun main() {

    fun part1(input: List<String>): Int {
        val gammaBits = mutableListOf<Char>()
        val size = input.first().length
        for (i in 0 until size) {
            val bits = input.map { it[i] }
            val ones = bits.count { it == '1' }
            val zeros = bits.count { it == '0' }
            gammaBits += if (ones > zeros) '1' else '0'
        }

        val gamma = Integer.parseInt(gammaBits.joinToString(""), 2)

        val epsilonBits = mutableListOf<Char>()
        for (i in 0 until size) {
            val bits = input.map { it[i] }
            val ones = bits.count { it == '1' }
            val zeros = bits.count { it == '0' }
            epsilonBits += if (zeros > ones) '1' else '0'
        }

        val epsilon = Integer.parseInt(epsilonBits.joinToString(""), 2)

        return gamma * epsilon
    }

    val testInput = readInput("day3_test")
    check(part1(testInput) == 198)

    val input = readInput("day3")
    println(part1(input))
}