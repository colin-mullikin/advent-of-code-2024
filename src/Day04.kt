fun main() {

    fun part1(input: Array<CharArray>): Int {
        var result = 0

        var row = 0
        while (row < input.size) {
            var column = 0
            while (column < input[row].size) {
                if (input[row][column] == 'X') {
                    result += Day04Utils.searchForXmasPart1(input, row, column)
                }
                column++
            }
            row++
        }

        return result
    }

    fun part2(input: Array<CharArray>): Int {
        var result = 0

        var row = 1
        while (row < input.lastIndex) {
            var column = 1
            while (column < input[row].lastIndex) {
                if (input[row][column] == 'A' && Day04Utils.searchForXmasPart2(input, row, column)) {
                    result += 1
                }
                column++
            }
            row++
        }

        return result
    }

    val testInputArray = readInputToMatrix("Day04_test")
    check(part1(testInputArray) == 18)
    check(part2(testInputArray) == 9)

    val input = readInputToMatrix("Day04")
    part1(input).println()
    part2(input).println()
}
