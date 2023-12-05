import java.io.File

fun num_matches_from_card(line: String) : Int {
    val splitline = line.split(":")
    val numbers = splitline[1].split("|")
    val winning_numbers = numbers[0].split(" ").toSet()
    val our_numbers = numbers[1].split(" ").toSet()

    val intersection = winning_numbers.intersect(our_numbers)

    // intersection also contains empty string as a member, don't want to count that
    return intersection.size - 1
}

fun day4_part1(): Double {

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day4_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day4_example.txt"
    val file = File(filename)

    var total_points = 0.0

    file.forEachLine { line ->
        val num_matches = num_matches_from_card(line)

        if (num_matches > 0) {
            total_points += Math.pow(2.0, num_matches - 1.0)
        }
    }
    return total_points
}

fun day4_part2(): Int {

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day4_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day4_example.txt"
    val file = File(filename)

    var total_points = 0.0

    // make map of card number to number of copies
    var card_to_count_map: MutableMap<Int, Int> = mutableMapOf()

    val lines_in_file = file.readLines()
    val num_lines = lines_in_file.size
    for (i in 1..num_lines) {
        card_to_count_map[i] = 1
    }


    for (line in lines_in_file) {
        val num_matches = num_matches_from_card(line)
        val splitline = line.split(":")
        val card_id = splitline[0].split(" ").last().toInt()
        val num_copies = card_to_count_map[card_id]!!

        for (i in (card_id + 1)..(card_id + num_matches)) {
            card_to_count_map[i] = card_to_count_map[i]!! + num_copies
        }
    }

    return (card_to_count_map.values).sum()
}


fun main() {
    //println(day4_part1())
    println(day4_part2())
}