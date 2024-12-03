fun main() {

    fun parseRow(row: String): List<Int> {
        return row.split(" ").map { it.toInt() }
    }

    fun isReportSafe(report: List<Int>): Boolean {
        if (report.first() == report[1]) {
            return false
        }

        val validDifferences = intArrayOf(1, 2, 3)

        val ascending = report.first() < report[1]
        for (i in 0..< report.lastIndex) {
            if (ascending) {
                if (report[i+1] - report[i] !in validDifferences) {
                    return false
                }
            } else {
                if (report[i] - report[i+1] !in validDifferences) {
                    return false
                }
            }
        }

        return true
    }

    fun isReportSafeWithRemoval(report: List<Int>): Boolean {
        if (isReportSafe(report)) {
            return true
        }

        for (skip in report.indices) {
            if (isReportSafe(report.filterIndexed { index, _ -> index != skip })) {
                return true
            }
        }

        return false
    }

    fun part1(input: List<String>): Int {
        return input.map { parseRow(it) }
            .count { isReportSafe(it) }
    }


    fun part2(input: List<String>): Int {
        return input.map { parseRow(it) }
            .count { isReportSafeWithRemoval(it) }
    }

    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
