package arrays_strings

fun main() {
    val s = "abfdskju"
    println(isUnique(s))
    println(isUnique2(s))
    println(isUnique3(s))
}

private fun isUnique(s: String) : Boolean {
    if (s.length > 128) return false

    val flags = mutableMapOf<Char, Boolean>()
    for (c in s) {
        if (c in flags) return false
        flags[c] = true
    }
    return true
}

private fun isUnique2(s: String) : Boolean {
    var bitVector = 0
    for (c in s) {
        val pos = c - 'a'
        if (bitVector and (1 shl pos) != 0) return false
        bitVector = bitVector or (1 shl pos)
    }
    return true
}

private fun isUnique3(s: String): Boolean {
    if (s.length > 128) return false

    val sortedString = s.toCharArray().sorted()
    return sortedString.windowed(size = 2, step = 1).none { it[0] == it[1] }
}