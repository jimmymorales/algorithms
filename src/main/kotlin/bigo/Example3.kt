package bigo

/**
 * EXAMPLE 2
 *
 * What is the runtime of the below code?
 */
private fun printPairs(array: IntArray) {
    for (i in array.indices) {
        for (j in (i + 1).. array.lastIndex) {
            println("${array[i]},${array[j]}")
        }
    }
}

/**
 * ANSWER 👇
 *
 * This will take O(N^2) time. Even tho the inner loop is getting slower every time we can remove the constant from the
 * notation. Instead of saying O((N^2)/2), it should only be O(N^2). The outer loop runs N times but the inner loop on
 * average runs N/2 times.
 *
 * Bonus: Same output but now using the std library functions.
 */
private fun printPairsKt(array: IntArray) {
    array.forEachIndexed { i, item1 ->
        array.drop(i + 1).forEach { item2 ->
            println("$item1,$item2")
        }
    }
}
