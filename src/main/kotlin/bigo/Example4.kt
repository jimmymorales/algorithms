package bigo

/**
 * EXAMPLE 4
 *
 * What is the runtime of the below code?
 */
private fun printUnorderedPairs(arrayA: IntArray, arrayB: IntArray) {
    for (a in arrayA) {
        for (b in arrayB) {
            if (a < b) {
                println("$a,$b")
            }
        }
    }
}

/**
 * ANSWER 👇
 *
 * This will take O(ab) time. This is because each array will have a different length (arrayA = a, arrayB = b).
 */