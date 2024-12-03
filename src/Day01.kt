import kotlin.math.abs

fun main() {

    fun splitInput(input: List<String>): Pair<ArrayList<Int>, ArrayList<Int>> {
        val left = ArrayList<Int>()
        val right = ArrayList<Int>()
        for (line in input) {
            val split = line.split("   ")
            left.add(split.first().toInt())
            right.add(split.last().toInt())
        }

        return Pair(left, right)
    }

    //Difference between left and right values, when sorted.
    fun part1(input: List<String>): Int {
        val leftRight = splitInput(input)
        leftRight.first.sort()
        leftRight.second.sort()

        var result = 0

        for (i in leftRight.first.indices) {
            result += abs(leftRight.first[i] - leftRight.second[i])
        }

        return result
    }


    fun part2(input: List<String>): Int {
        val leftRight = splitInput(input)
        var result = 0

        for (i in leftRight.first.indices) {
            result += leftRight.first[i] * leftRight.second.count { it == leftRight.first[i] }
        }
        return result
    }

    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
