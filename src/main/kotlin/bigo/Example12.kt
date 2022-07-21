package bigo

/**
 * EXAMPLE 12
 *
 * What is the runtime of the below code?
 * It computes n! (n factorial).
 *
 */
private fun permutation(str: String) {
    permutation(str, prefix = "")
}

private fun permutation(str: String, prefix: String) {
    if (str.isEmpty()) {
        println(prefix)
        return
    }
    for (i in str.indices) {
        val rem = str.substring(0, i) + str.substring(i + 1)
        permutation(rem, prefix + str[i])
    }
}

/**
 * ANSWER 👇
 *
 * This will take O(n * n!) time. Where O(n) is the time for printing every permutation and there will be O(n!)
 * permutations. This can be simplified to O((n + 1)!)
 */