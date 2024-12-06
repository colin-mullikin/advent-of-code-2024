class Day04Utils {
    companion object {
        private fun searchUpLeft(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row-1][column-1] == 'M' && input[row-2][column-2] == 'A' && input[row-3][column-3] == 'S'
        }

        private fun searchUp(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row-1][column] == 'M' && input[row-2][column] == 'A' && input[row-3][column] == 'S'
        }

        private fun searchUpRight(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row-1][column+1] == 'M' && input[row-2][column+2] == 'A' && input[row-3][column+3] == 'S'
        }

        private fun searchLeft(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row][column-1] == 'M' && input[row][column-2] == 'A' && input[row][column-3] == 'S'
        }

        private fun searchRight(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row][column+1] == 'M' && input[row][column+2] == 'A' && input[row][column+3] == 'S'
        }

        private fun searchDownLeft(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row+1][column-1] == 'M' && input[row+2][column-2] == 'A' && input[row+3][column-3] == 'S'
        }

        private fun searchDown(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row+1][column] == 'M' && input[row+2][column] == 'A' && input[row+3][column] == 'S'
        }

        private fun searchDownRight(input: Array<CharArray>, row: Int, column: Int): Boolean {
            return input[row+1][column+1] == 'M' && input[row+2][column+2] == 'A' && input[row+3][column+3] == 'S'
        }

        fun searchForXmas(input: Array<CharArray>, row: Int, column: Int): Int {
            val lastRow = input.lastIndex
            val lastColumn = input[0].lastIndex

            var result = 0

            val canSearchLeft = column >= 3
            val canSearchRight = column <= lastColumn-3
            val canSearchUp = row >= 3
            val canSearchDown = row <= lastRow-3

            if (canSearchUp && canSearchLeft && searchUpLeft(input, row, column)) {
                result += 1
            }

            if (canSearchUp && searchUp(input, row, column)) {
                result += 1
            }

            if (canSearchUp && canSearchRight && searchUpRight(input, row, column)) {
                result += 1
            }

            if (canSearchLeft && searchLeft(input, row, column)) {
                result += 1
            }

            if (canSearchRight && searchRight(input, row, column)) {
                result += 1
            }

            if (canSearchDown && canSearchLeft && searchDownLeft(input, row, column)) {
                result += 1
            }

            if (canSearchDown && searchDown(input, row, column)) {
                result += 1
            }

            if (canSearchDown && canSearchRight && searchDownRight(input, row, column)) {
                result += 1
            }

            return result
        }
    }
}
