package arrays_strings

fun main() {
    val s1 = "asdf"
    val s2 = "fgsa"
    println(checkPermutation(s1, s2))
}

private fun checkPermutation(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val flags = mutableMapOf<Char, Int>().withDefault { 0 }
    s.forEach { c -> flags[c] = flags.getValue(c) + 1 }

    for (c in t) {
        flags[c] = flags.getValue(c) - 1
        if (flags.getValue(c) < 0) return false
    }

    return true
}
