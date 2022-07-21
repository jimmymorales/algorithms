package arrays_strings

fun main() {
    val s = "Mr John Smith         ".toCharArray()
    urlify(s, 13)
    println(s.joinToString(separator = ""))
}

private fun urlify(s: CharArray, trueLength: Int) {
    val spaces = (0 until trueLength).count { s[it] == ' ' }

    var oldIndex = trueLength - 1
    var newIndex = spaces * 2 + trueLength - 1

    ((newIndex + 1).. s.lastIndex).forEach { s[it] = '\u0000' }

    while (oldIndex >= 0) {
        if (s[oldIndex] == ' ') {
            s[newIndex] = '0'
            s[newIndex - 1] = '2'
            s[newIndex - 2] = '%'
            newIndex -= 3
        } else {
            s[newIndex] = s[oldIndex]
            newIndex--
        }
        oldIndex--
    }
}
