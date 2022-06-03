package tictactoe

import java.util.*

object Move {
    fun move(grid: Grid): Boolean {
        var isContinue = true
        val scanner = Scanner(System.`in`)
        print("Enter the coordinates: ")
        val coordinates = scanner.nextLine().split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        when (checkCoordinates(parseCoordinates(coordinates))) {
            "notNumber" -> println("You should enter numbers!")
            "outOfRange" -> println("Coordinates should be from 1 to 3!")
            "available" -> if (checkMove(parseCoordinates(coordinates), grid)) {
                makeMove(parseCoordinates(coordinates), grid)
                isContinue = false
            } else {
                println("This cell is occupied! Choose another one!")
            }
        }
        return isContinue
    }

    private fun parseCoordinates(coordinates: Array<String>): IntArray {
        val coordinateToInt = intArrayOf(-1, -1)
        try {
            coordinateToInt[0] = coordinates[0].toInt() - 1
            coordinateToInt[1] = coordinates[1].toInt() - 1
        } catch (ignored: IllegalArgumentException) {
            // to do
        }
        return coordinateToInt
    }

    private fun checkCoordinates(coordinateToInt: IntArray): String {
        var check = ""
        for (j in coordinateToInt) {
            if (j == -1) {
                check = "notNumber"
                break
            } else if (j in 0..2) {
                check = "available"
            } else {
                check = "outOfRange"
                break
            }
        }
        return check
    }

    private fun checkMove(coordinateToInt: IntArray, grid: Grid): Boolean {
        return grid.getGrid()[coordinateToInt[0]][coordinateToInt[1]] == ' '
    }

    private fun makeMove(coordinateToInt: IntArray, grid: Grid) {
        val move = grid.getGrid()
        move[coordinateToInt[0]][coordinateToInt[1]] = 'X'
        grid.setGrid(move)
    }
}