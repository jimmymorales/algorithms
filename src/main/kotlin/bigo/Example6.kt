package bigo

/**
 * EXAMPLE 6
 *
 * What is the runtime of the below code?
 */
private fun reverse(array: IntArray) {
    for (i in 0..array.size / 2) {
        val other = array.size - i - 1
        val temp = array[i]
        array[i] = array[other]
        array[other] = temp
    }
}

/**
 * ANSWER 👇
 *
 * This will also take O(N) time. We can ignore the fact that it will only iterate half of the array, that is a constant
 */