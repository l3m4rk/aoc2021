import kotlin.math.abs

/**
 * @author l3m4rk
 * Created on 03.12.2021.
 */

fun main() {
    println(part1())
    println(part2())
}

data class Command(
    val type: CommandType,
    val units: Int
)

@Suppress("EnumEntryName")
enum class CommandType {
    up,
    down,
    forward
}

data class Position(
    val horizontal: Int = 0,
    val depth: Int = 0,
)

data class PositionWithAim(
    val horizontal: Int = 0,
    val depth: Int = 0,
    val aim: Int = 0
)

fun part1(): Int =
    readCommands()
        .fold(Position()) { position: Position, command: Command ->
            when (command.type) {
                CommandType.up -> position.copy(depth = position.depth - command.units)
                CommandType.down -> position.copy(depth = position.depth + command.units)
                CommandType.forward -> position.copy(horizontal = position.horizontal + command.units)
            }
        }
        .let { position -> position.horizontal * position.depth }

fun part2() = readCommands()
    .fold(PositionWithAim()) { pwa, command ->
        when (command.type) {
            CommandType.down -> {
                pwa.copy(aim = pwa.aim + command.units)
            }
            CommandType.up -> {
                pwa.copy(aim = pwa.aim - command.units)
            }
            CommandType.forward -> {
                pwa.copy(
                    horizontal = pwa.horizontal + command.units,
                    depth = pwa.depth + pwa.aim * command.units,
                )
            }
        }
    }
    .let { position -> position.horizontal * position.depth }

private fun readCommands() = readInput("day2").map {
    val (command, units) = it.split(" ")
    Command(
        type = CommandType.valueOf(command),
        units = units.toInt()
    )
}
