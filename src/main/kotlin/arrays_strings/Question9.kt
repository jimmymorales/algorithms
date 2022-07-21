package arrays_strings

private fun isRotation(s1: String, s2: String): Boolean {
    if (s1.length != s2.length || s1.isEmpty()) {
        return false
    }
    val s1s1 = s1 + s1
    return s1s1.indexOf(s2) != -1
}
