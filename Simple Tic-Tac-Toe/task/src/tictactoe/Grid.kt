package tictactoe

import java.util.*

class Grid internal constructor() {
    private var grid = Array(3) { CharArray(3) }
    private val rotatedGrid = Array(3) { CharArray(3) }
    var sides = Array(3) { CharArray(3) }
        private set

    init {
        val scanner = Scanner(System.`in`)
        print("Enter cells: ")
        var symbols = scanner.nextLine()
        if (symbols.length == 9) {
            symbols = symbols.replace("_".toRegex(), " ")
            var j = 0
            for (i in 0..2) {
                grid[0][i] = symbols[j]
                j++
            }
            for (i in 0..2) {
                grid[1][i] = symbols[j]
                j++
            }
            for (i in 0..2) {
                grid[2][i] = symbols[j]
                j++
            }
            //diagonal
            val diagonal1 = CharArray(3)
            for (i in 0..2) {
                diagonal1[i] = grid[i][i]
            }
            val diagonal2 = CharArray(3)
            diagonal2[0] = grid[0][2]
            diagonal2[1] = grid[1][1]
            diagonal2[2] = grid[2][0]
            //rotatedGrid
            for (i in 0..2) {
                for (k in 0..2) {
                    rotatedGrid[i][k] = grid[k][i]
                }
            }
            sides = arrayOf(
                grid[0], grid[1], grid[2], rotatedGrid[0], rotatedGrid[1], rotatedGrid[2],
                diagonal1, diagonal2
            )
        }
    }

    fun setGrid(grid: Array<CharArray>) {
        this.grid = grid
        //diagonal
        val diagonal1 = CharArray(3)
        for (i in 0..2) {
            diagonal1[i] = grid[i][i]
        }
        val diagonal2 = CharArray(3)
        diagonal2[0] = grid[0][2]
        diagonal2[1] = grid[1][1]
        diagonal2[2] = grid[2][0]
        //rotatedGrid
        for (i in 0..2) {
            for (k in 0..2) {
                rotatedGrid[i][k] = grid[k][i]
            }
        }
        sides = arrayOf(
            grid[0], grid[1], grid[2], rotatedGrid[0], rotatedGrid[1], rotatedGrid[2],
            diagonal1, diagonal2
        )
    }

    fun getGrid(): Array<CharArray> {
        return grid
    }

    override fun toString(): String {
        val gridBuilder = StringBuilder()
        for (row in grid) {
            gridBuilder.append("| ")
            for (ch in row) {
                gridBuilder.append("$ch ")
            }
            gridBuilder.append("|").append("\n").append("            ")
        }

        return """
            ---------
            ${gridBuilder.toString().trim()}
            ---------
        """.trimIndent()
    }
}