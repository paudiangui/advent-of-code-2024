package day3

import utils.Utils
import utils.Utils.BASE_PATH

fun main() {
    part1()
    part2()
}

fun part1(){
    val inputFilePathPart1 = "${BASE_PATH}day3/day3Part1.txt"

    val inputText = Utils.readFileToString(inputFilePathPart1)

    val regex = Regex("mul\\((\\d+),(\\d+)\\)")

    val result = regex.findAll(inputText)
        .sumOf { match ->
            sumMatches(match)
        }

    println(result)
}

fun part2(){
    val inputFilePathPart2 = "${BASE_PATH}day3/day3Part1.txt"

    val regex = Regex("mul\\((\\d+),(\\d+)\\)|(?:do\\(\\)|don't\\(\\))")

    val inputText = Utils.readFileToString(inputFilePathPart2)
    
    var isEnabled = true
    val sum = regex.findAll(inputText).sumOf { match ->
        when (match.value) {
            "do()" -> {
                isEnabled = true
                0 // No suma nada en este caso
            }
            "don't()" -> {
                isEnabled = false
                0 // No suma nada en este caso
            }
            else -> if (isEnabled) sumMatches(match) else 0
        }
    }

    println(sum)
}

fun sumMatches(match: MatchResult): Int{
    return match.groupValues[1].toInt() * match.groupValues[2].toInt()
}