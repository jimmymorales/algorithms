package arrays_strings

fun main() {
    val input = "Tact Coa"
    println(isPalindromePermutation(input))
}

private fun isPalindromePermutation(s: String): Boolean {
    var bitVector = 0
    for (c in s) {
        val lowerC = c.lowercase()[0]
        if (lowerC > 'z' || lowerC < 'a') continue
        val pos = lowerC - 'a'
        bitVector = bitVector xor (1 shl pos)
    }

    return (bitVector and (bitVector - 1)) == 0
}