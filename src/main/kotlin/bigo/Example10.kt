package bigo

/**
 * EXAMPLE 10
 *
 * What is the runtime of the below code?
 *
 */
private fun isPrime(n: Int): Boolean {
    var x = 2
    while (x * x <= n) {
        if (n % x == 0) {
            return false
        }
        x++
    }
    return true
}

/**
 * ANSWER 👇
 *
 * This will take O(sqrt(n)) time. The loop will go from 2 to the square root of n.
 */
