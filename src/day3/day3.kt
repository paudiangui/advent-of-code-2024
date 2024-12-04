package day3

import utils.Utils
import utils.Utils.BASE_PATH

fun main() {
    val inputFilePathPart1 = "${BASE_PATH}day3/day3Part1.txt"

    val inputText = Utils.readFileToString(inputFilePathPart1)

    val regex = Regex("mul\\((\\d+),(\\d+)\\)")
    
    val matches = regex.findAll(inputText)

    var result = 0

    for (match in matches){
        result += match.groupValues[1].toInt() * match.groupValues[2].toInt()
    }

    println(result)

}