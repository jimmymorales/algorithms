package arrays_strings

private fun zeroMatrix(matrix: Array<Array<Int>>) {
    var rowHasZero = false
    var columnHasZero = false

    for (v in matrix[0]) {
        if (v == 0) {
            rowHasZero = true
            break
        }
    }

    for (x in matrix.indices) {
        if (matrix[x][0] == 0) {
            columnHasZero = true
            break
        }
    }

    for (x in 1..matrix.lastIndex) {
        for (y in 1..matrix[x].lastIndex) {
            if (matrix[x][y] == 0) {
                matrix[0][y] = 0
                matrix[x][0] = 0
            }
        }
    }

    for (x in matrix.indices) {
        if (matrix[x][0] == 0) {
            matrix[x].indices.forEach { y -> matrix[x][y] = 0 }
        }
    }

    for (y in matrix[0].indices) {
        if (matrix[0][y] == 0) {
            matrix.indices.forEach { x -> matrix[x][y] = 0 }
        }
    }

    if (rowHasZero) {
        matrix[0].indices.forEach { y -> matrix[0][y] = 0 }
    }

    if (columnHasZero) {
        matrix.indices.forEach { y -> matrix[y][0] = 0 }
    }
}