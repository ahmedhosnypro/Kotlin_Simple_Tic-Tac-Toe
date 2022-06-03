package tictactoe

import java.util.*
import kotlin.math.abs

object GridState {
    private const val O_WINS = "O wins"
    private const val X_WINS = "X wins"
    fun state(grid: Grid): String {
        val check: String?
        var xCount = 0
        var oCount = 0
        var emptyCount = 0
        for (row in grid.getGrid()) {
            for (ch in row) {
                when (ch) {
                    'X' -> {
                        xCount++
                    }
                    'O' -> {
                        oCount++
                    }
                    ' ' -> {
                        emptyCount++
                    }
                }
            }
        }
        check = if (abs(xCount - oCount) > 1) {
            "Impossible"
        } else {
            when (checkSides(grid)) {
                "Impossible" -> "Impossible"
                X_WINS -> X_WINS
                O_WINS -> O_WINS
                else -> checkEmptyCells(emptyCount)
            }
        }

        return check
    }

    private fun checkEmptyCells(emptyCount: Int): String {
        if (emptyCount == 0) {
            return "Draw"
        }
        if (emptyCount > 0) {
            return "Game not finished"
        }
        return "error"
    }


    private fun simpleSides(grid: Grid): CharArray {
        val sides = grid.sides
        val simpleSides = CharArray(grid.sides.size)
        Arrays.fill(simpleSides, 'A')
        for (i in sides.indices) {
            var last = sides[i][0]
            var isInRow = true
            for (j in 1..2) {
                if (sides[i][j] == last) {
                    last = sides[i][j]
                } else {
                    isInRow = false
                    break
                }
            }
            if (isInRow) {
                simpleSides[i] = sides[i][0]
            }
        }
        return simpleSides
    }

    private fun checkSides(grid: Grid): String {
        var check = ""
        val sides: CharArray = simpleSides(grid)
        var xCount = 0
        var oCount = 0
        for (i in sides.indices) {
            if (sides[i] == 'X') {
                xCount++
            } else if (sides[i] == 'O') {
                oCount++
            }
        }
        if (xCount > 0 && oCount > 0) {
            check = "Impossible"
        } else {
            if (xCount == 1 || xCount == 2) {
                check = X_WINS
            } else if (oCount == 1 || oCount == 2) {
                check = O_WINS
            } else if (xCount == oCount) {
                check = "Draw"
            }
        }
        return check
    }
}