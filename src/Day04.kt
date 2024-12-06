fun main() {

    fun part1(input: Array<CharArray>): Int {
        var result = 0

        var row = 0
        while (row < input.size) {
            var column = 0
            while (column < input[row].size) {
                if (input[row][column] == 'X') {
                    result += Day04Utils.searchForXmas(input, row, column)
                }
                column++
            }
            row++
        }

        return result
    }

    fun part2(input: Array<CharArray>): Int {
        return 0
    }

    val testInputArray = readInputToMatrix("Day04_test")
    check(part1(testInputArray) == 18)
    check(part2(testInputArray) == 9)

    val input = readInputToMatrix("Day04")
    part1(input).println()
    part2(input).println()
}
