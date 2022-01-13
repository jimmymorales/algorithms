package bigo

/**
 * EXAMPLE 1
 *
 * What is the runtime of the below code?
 */
private fun foo(array: IntArray) {
    var sum = 0
    var product = 1
    for (i in array.indices) {
        sum += array[i]
    }
    for (i in array.indices) {
        product *= array[i]
    }
    println("$sum, $product")
}

/**
 * ANSWER 👇
 *
 * This will take O(N) time. Even tho we are iterating over the array twice O(2N), we can remove the constant and just
 * leave it as O(N). Also, because this can be done with a single iteration:
 */
private fun foo2(array: IntArray) {
    var sum = 0
    var product = 1
    for (i in array.indices) {
        sum += array[i]
        product *= array[i]
    }
    println("$sum, $product")
}

/**
 * This is more kotlin idiomatic
 */
private fun fooKt(array: IntArray) {
    val sum = array.sum()
    val product = array.fold(initial = 1) { acc, i -> acc * i }
    println("$sum, $product")
}