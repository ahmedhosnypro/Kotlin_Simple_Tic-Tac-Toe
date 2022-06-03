package tictactoe

import tictactoe.Move.move

fun main() {
    val grid = Grid()
    println(grid)

    var toContinue = true
    while (toContinue) {
        toContinue = move(grid)
    }

    println(grid)
}
