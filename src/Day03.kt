fun main() {

    fun part1(input: List<String>): Int {
        val regex = Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)""")
        var result = 0
        for (line in input) {
            val sequence = regex.findAll(line)
            sequence.forEach { matchResult -> result += matchResult.groupValues[1].toInt() * matchResult.groupValues[2].toInt() }
        }
        return result
    }


    fun part2(input: List<String>): Int {
        val regex = Regex("""mul\(([0-9]{1,3}),([0-9]{1,3})\)|do(?:n't){0,1}\(\)""")
        var result = 0
        var enabled = true
        for (line in input) {
            regex.findAll(line).forEach { matchResult ->
                run {
                    when {
                        matchResult.groupValues[0] == "do()" -> { enabled = true }
                        matchResult.groupValues[0] == "don't()" -> { enabled = false }
                        else -> {
                            if (enabled) {
                                result += matchResult.groupValues[1].toInt() * matchResult.groupValues[2].toInt()
                            }
                        }
                    }
                }
            }
        }
        return result
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
