package bigo

/**
 * EXAMPLE 11
 *
 * What is the runtime of the below code?
 * It computes n! (n factorial).
 *
 */
private fun factorial(n: Int): Int = when {
    n < 0 -> -1
    n == 0 -> 1
    else -> n * factorial(n - 1)
}

/**
 * ANSWER 👇
 *
 * This will take O(N) time. It's iterating from n down to 1.
 */