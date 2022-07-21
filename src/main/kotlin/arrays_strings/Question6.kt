package arrays_strings

fun main() {
    val s = "aabcccccaaa"
    println(compress1(s))
    println(compress2(s))
}

private fun compress1(s: String): String {
    val sb = StringBuilder()
    var counter = 0
    for (i in s.indices) {
        counter++
        if (i + 1 >= s.length || s[i + 1] != s[i]) {
            sb.append("${s[i]}$counter")
            counter = 0
        }
    }

    return if (s.length <= sb.length) s else sb.toString()
}

private fun compress2(s: String): String {
    var sequences = 0
    for (i in s.indices) {
        if (i + 1 >= s.length || s[i + 1] != s[i]) {
            sequences += 2
        }
    }
    if (s.length <= sequences) return s

    val sb = StringBuilder(sequences)
    var counter = 0
    for (i in s.indices) {
        counter++
        if (i + 1 >= s.length || s[i + 1] != s[i]) {
            sb.append("${s[i]}$counter")
            counter = 0
        }
    }
    return sb.toString()
}