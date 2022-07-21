package arrays_strings

import kotlin.math.abs

fun main() {
    println(checkOneEditAway("pale", "ple"))
    println(checkOneEditAway("pales", "pale"))
    println(checkOneEditAway("pale", "bale"))
    println(checkOneEditAway("pale", "bake"))
}

private fun checkOneEditAway(s: String, t: String): Boolean {
    if (abs(s.length - t.length) > 1) return false

    val s1 = if (s.length > t.length) s else t
    val s2 = if (s.length > t.length) t else s

    var index1 = 0
    var index2 = 0
    var isEdited = false

    while (index1 < s1.length && index2 < s2.length ) {
        if (s1[index1] != s2[index2]) {
            if (isEdited) return false
            isEdited = true

            if (s1.length == s2.length) {
                index2++
            }
        } else {
            index2++
        }
        index1++
    }

    return true
}