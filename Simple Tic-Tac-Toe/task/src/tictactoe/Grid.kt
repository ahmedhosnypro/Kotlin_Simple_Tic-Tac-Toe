package tictactoe

class Grid internal constructor() {
    private var grid = Array(3) { CharArray(3) }
    private var diagonal1 = CharArray(3)
    private var diagonal2 = CharArray(3)
    private val rotatedGrid = Array(3) { CharArray(3) }
    var sides = Array(3) { CharArray(3) }
        private set

    init {
        for (i in 0..2) {
            for (j in 0..2) {
                grid[i][j] = ' '
            }
        }
        setRotatedGrid()
        setDiagonal1()
        setDiagonal2()
        setSides()
    }

    fun setGrid(coordinates: IntArray, playChar: Char) {
        grid[coordinates[0]][coordinates[1]] = playChar
        setRotatedGrid()
        setDiagonal1()
        setDiagonal2()
        setSides()
    }

    fun getGrid(): Array<CharArray> {
        return grid
    }

    private fun setRotatedGrid() {
        for (i in 0..2) {
            for (k in 0..2) {
                rotatedGrid[i][k] = grid[k][i]
            }
        }
    }

    private fun setDiagonal1() {
        for (i in 0..2) {
            diagonal1[i] = grid[i][i]
        }
    }

    private fun setDiagonal2() {
        diagonal2[0] = grid[0][2]
        diagonal2[1] = grid[1][1]
        diagonal2[2] = grid[2][0]
    }

    private fun setSides() {
        sides = arrayOf(
            grid[0], grid[1], grid[2], rotatedGrid[0], rotatedGrid[1], rotatedGrid[2],
            diagonal1, diagonal2
        )
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