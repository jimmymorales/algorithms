package bigo

/**
 * EXAMPLE 2
 *
 * What is the runtime of the below code?
 */
private fun printPairs(array: IntArray) {
    for (item1 in array) {
        for (item2 in array) {
            println("$item1, $item2")
        }
    }
}

/**
 * ANSWER 👇
 *
 * This will take O(N^2) time. This makes sense because the code is printing all the pairs that can be formed with the
 * array and there are N^2 pairs in total.
 */