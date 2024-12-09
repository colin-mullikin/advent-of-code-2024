object Day04Utils {

    /*
    Part 1 Utils.
     */
    private fun searchUpLeft(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row-1][column-1] == 'M' && input[row-2][column-2] == 'A' && input[row-3][column-3] == 'S') 1 else 0
    }

    private fun searchUp(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row-1][column] == 'M' && input[row-2][column] == 'A' && input[row-3][column] == 'S') 1 else 0
    }

    private fun searchUpRight(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row-1][column+1] == 'M' && input[row-2][column+2] == 'A' && input[row-3][column+3] == 'S') 1 else 0
    }

    private fun searchLeft(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row][column-1] == 'M' && input[row][column-2] == 'A' && input[row][column-3] == 'S') 1 else 0
    }

    private fun searchRight(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row][column+1] == 'M' && input[row][column+2] == 'A' && input[row][column+3] == 'S') 1 else 0
    }

    private fun searchDownLeft(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row+1][column-1] == 'M' && input[row+2][column-2] == 'A' && input[row+3][column-3] == 'S') 1 else 0
    }

    private fun searchDown(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row+1][column] == 'M' && input[row+2][column] == 'A' && input[row+3][column] == 'S') 1 else 0
    }

    private fun searchDownRight(input: Array<CharArray>, row: Int, column: Int): Int {
        return if (input[row+1][column+1] == 'M' && input[row+2][column+2] == 'A' && input[row+3][column+3] == 'S') 1 else 0
    }

    fun searchForXmasPart1(input: Array<CharArray>, row: Int, column: Int): Int {
        val lastRow = input.lastIndex
        val lastColumn = input[0].lastIndex

        var result = 0

        val canSearchLeft = column >= 3
        val canSearchRight = column <= lastColumn-3
        val canSearchUp = row >= 3
        val canSearchDown = row <= lastRow-3

        if (canSearchUp) {
            result += searchUp(input, row, column)

            if (canSearchLeft) {
                result += searchUpLeft(input, row, column)
            }

            if (canSearchRight) {
                result += searchUpRight(input, row, column)
            }
        }

        if (canSearchLeft) {
            result += searchLeft(input, row, column)
        }

        if (canSearchRight) {
            result += searchRight(input, row, column)
        }

        if (canSearchDown) {
            result += searchDown(input, row, column)

            if (canSearchLeft) {
                result += searchDownLeft(input, row, column)
            }

            if (canSearchRight) {
                result += searchDownRight(input, row, column)
            }
        }

        return result
    }

    /*
    Part 2 Utils
     */
    fun searchForXmasPart2(input: Array<CharArray>, row: Int, column: Int): Boolean {
        return (input[row-1][column-1] == 'M' && input[row+1][column+1] == 'S' && input[row-1][column+1] == 'M' && input[row+1][column-1] == 'S') ||
               (input[row-1][column-1] == 'M' && input[row+1][column+1] == 'S' && input[row-1][column+1] == 'S' && input[row+1][column-1] == 'M') ||
               (input[row-1][column-1] == 'S' && input[row+1][column+1] == 'M' && input[row-1][column+1] == 'M' && input[row+1][column-1] == 'S') ||
               (input[row-1][column-1] == 'S' && input[row+1][column+1] == 'M' && input[row-1][column+1] == 'S' && input[row+1][column-1] == 'M')
    }
}
