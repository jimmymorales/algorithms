package bigo

/**
 * EXAMPLE 5
 *
 * What is the runtime of the below code?
 */
private fun printUnorderedPairs(arrayA: IntArray, arrayB: IntArray) {
    for (a in arrayA) {
        for (b in arrayB) {
            repeat(100_000) {
                println("$a,$b")
            }
        }
    }
}

/**
 * ANSWER 👇
 *
 * Similar to example 4, this will also take O(ab) time. The most inner loop of 100,000 iterations is constant and it
 * shouldn't be part of the runtime.
 */