import java.io.File

fun part1() {

    val integers: Set<Char> = "0123456789".toSet()
    var sum = 0
    println(integers)

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day1_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day1_example.txt"
    val file = File(filename)

    file.forEachLine { line ->
        var first: Char = '0'
        var last: Char = '0'

        for (c: Char in line) {
            if (c in integers) {
                first = c
                break
            }
        }
        for (c in line.reversed()) {
            if (c in integers) {
                last = c
                break
            }
        }
        val fullNumber:String = "" + first + last
        //println(fullNumber)
        sum += fullNumber.toInt()
    }

    println(sum)
}

fun part2() {
    val numberMap =mapOf(
        "one" to '1',
        "two" to '2',
        "three" to '3',
        "four" to '4',
        "five" to '5',
        "six" to '6',
        "seven" to '7',
        "eight" to '8',
        "nine" to '9'
    )

    val reversedNumberMap =mapOf(
        "one".reversed() to '1',
        "two".reversed() to '2',
        "three".reversed() to '3',
        "four".reversed() to '4',
        "five".reversed() to '5',
        "six".reversed() to '6',
        "seven".reversed() to '7',
        "eight".reversed() to '8',
        "nine".reversed() to '9'
    )
    println(reversedNumberMap)
    val integers:Set<String> = setOf("0", "1", "2", "3", "4", "5", "6", "7", "8", "9")

    var sum = 0
    println(integers)

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day1_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day1_example.txt"
    val file = File(filename)

    file.forEachLine { line ->
        var first: Char = '0'
        var last: Char = '0'

        var integer_idx_num = line.findAnyOf(integers)
        var word_idx_num = line.findAnyOf(numberMap.keys)

        if (integer_idx_num?.first ?: Int.MAX_VALUE < word_idx_num?.first ?: Int.MAX_VALUE) {
            first = integer_idx_num?.second!![0]
        } else {
            first = numberMap[word_idx_num?.second!!]!!
        }

        val reversedLine = line.reversed()
        var last_integer_idx_num = reversedLine.findAnyOf(integers)
        var last_word_idx_num = reversedLine.findAnyOf(reversedNumberMap.keys)

        if (last_integer_idx_num?.first ?: Int.MAX_VALUE < last_word_idx_num?.first ?: Int.MAX_VALUE) {
            last = last_integer_idx_num?.second!![0]
        } else {
            last = reversedNumberMap[last_word_idx_num?.second!!]!!
        }
        val fullNumber:String = "" + first + last
        //println(fullNumber)
        sum += fullNumber.toInt()
    }

    println(sum)
}

fun main() {
    part2()
}