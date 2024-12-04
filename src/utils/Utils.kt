package utils

import java.io.File

object Utils {

    const val BASE_PATH = "/Users/paudiaz/projects-pau/advent-of-code/2024/advent-of-code-2024/src/"


    fun readFileToList(filePath: String): List<String>{
        return try {
            File(filePath).readLines()
        }catch (e: Exception){
            println("Error al leer el archivo: ${e.message}")
            emptyList()
        }
    }

    fun readFileToString(filePath: String): String{
        return try {
            File(filePath).readText()
        }catch (e: Exception){
            println("Error al leer el archivo: ${e.message}")
            ""
        }
    }
}