package arrays_strings

private fun rotate(matrix: Array<Array<Int>>): Boolean {
    if (matrix.isEmpty() || matrix.size != matrix[0].size) return false

    val n = matrix.size
    for (layer in 0 .. (n / 2)) {
        val last = n - layer - 1
        for (i in layer..last) {
            val offset = i - layer
            val top = matrix[layer][i]
            matrix[layer][i] = matrix[last-offset][layer]
            matrix[last-offset][layer] = matrix[last][last-offset]
            matrix[last][last-offset] = matrix[i][last]
            matrix[i][last] = top
        }
    }

    return true
}