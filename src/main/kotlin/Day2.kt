import java.io.File

fun day2_part1(max_red: Int, max_green: Int, max_blue: Int) : Int {

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day2_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day2_example.txt"
    val file = File(filename)

    var sum_ids = 0
    //val possible_colours = listOf("red", "green", "blue")

    file.forEachLine { line ->
        val segments: List<String> = line.split(":")
        val id_start_idx = "Game ".length
        val game_id = (segments[0].substring(id_start_idx)).toInt()

        var max_red_seen = 0
        var max_green_seen = 0
        var max_blue_seen = 0


        var rounds = segments[1].split(";")
        for (round in rounds) {
            var colours = round.split(',')
            for (num_colour in colours) {
                val num_colour_segments = num_colour.split(" ")
                // [, X, col]
                //println(num_colour_segments)
                val num_of_colour = num_colour_segments[1].trim().toInt()
                when(num_colour_segments[2]) {
                    "red" ->
                        if(num_of_colour > max_red_seen) {
                            max_red_seen = num_of_colour
                        }
                    "green" ->
                        if(num_of_colour > max_green_seen) {
                            max_green_seen = num_of_colour
                        }
                    "blue" ->
                        if(num_of_colour > max_blue_seen) {
                            max_blue_seen = num_of_colour
                        }
                }
            }
        }
        println(" Max seen this game: Red :$max_red_seen, Green: $max_green_seen, Blue: $max_blue_seen")
        if (max_red_seen <= max_red && max_green_seen <= max_green && max_blue_seen <= max_blue) {
            println("Game $game_id is possible")
            sum_ids += game_id
        }

    }
    return sum_ids
}

fun day2_part2() : Int {

    val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day2_data.txt"
    //val filename = "/Users/zeev/IdeaProjects/AdventOfCode2023/src/main/kotlin/day2_example.txt"
    val file = File(filename)

    var sum_powers = 0

    file.forEachLine { line ->
        val segments: List<String> = line.split(":")
        val id_start_idx = "Game ".length
        val game_id = (segments[0].substring(id_start_idx)).toInt()

        var max_red_seen = 0
        var max_green_seen = 0
        var max_blue_seen = 0


        var rounds = segments[1].split(";")
        for (round in rounds) {
            var colours = round.split(',')
            for (num_colour in colours) {
                val num_colour_segments = num_colour.split(" ")
                // [, X, col]
                //println(num_colour_segments)
                val num_of_colour = num_colour_segments[1].trim().toInt()
                when(num_colour_segments[2]) {
                    "red" ->
                        if(num_of_colour > max_red_seen) {
                            max_red_seen = num_of_colour
                        }
                    "green" ->
                        if(num_of_colour > max_green_seen) {
                            max_green_seen = num_of_colour
                        }
                    "blue" ->
                        if(num_of_colour > max_blue_seen) {
                            max_blue_seen = num_of_colour
                        }
                }
            }
        }
        val game_power = max_red_seen * max_green_seen * max_blue_seen
        println("Game power: $game_power")
        sum_powers += game_power

    }
    return sum_powers

}


fun main() {
    //println(day2_part1(12, 13,14))
    println(day2_part2())
}