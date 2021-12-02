import java.io.File

/**
 * @author l3m4rk
 * Created on 02.12.2021.
 */

internal fun readInput(name: String): List<String> =
    File("src/main/resources/$name.txt").readLines()

internal fun readNumbers(name: String): List<Int> =
    File("src/main/resources/$name.txt")
        .readLines()
        .map { it.toInt() }