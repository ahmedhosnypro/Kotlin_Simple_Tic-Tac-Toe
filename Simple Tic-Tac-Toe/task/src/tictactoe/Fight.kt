package tictactoe

import tictactoe.GridState.state
import tictactoe.Move.move

object Fight {
    private const val O_WINS = "O wins"
    private const val X_WINS = "X wins"

    fun startFight() {
        val grid = Grid()
        println(grid)
        for (i in 0..8) {
            when (state(grid)) {
                X_WINS -> {
                    println(X_WINS)
                    break
                }
                O_WINS -> {
                    println(O_WINS)
                    break
                }
                "Draw" -> {
                    println("Draw")
                    break
                }
                else -> {
                    val playChar: Char = if (i % 2 == 0) {
                        'X'
                    } else {
                        'O'
                    }
                    var toContinue = true
                    while (toContinue) {
                        toContinue = move(grid, playChar)
                    }
                    println(grid)
                }
            }
        }
        println(state(grid))
    }
}