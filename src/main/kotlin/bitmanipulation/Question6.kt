package bitmanipulation

fun main() {
	println(bitSwapRequired(29, 15))
	assert(bitSwapRequired2(29, 15) == 2)

	assert(
		bitSwapRequired(15, 29) == bitSwapRequired2(15, 29)
	)
}

private fun bitSwapRequired(a: Int, b: Int): Int {
	var count = 0
	var c = a xor b
	while (c != 0) {
		count += c and 1
		c = c shr 1
	}
	return count
}

private fun bitSwapRequired2(a: Int, b: Int): Int {
	var count = 0
	var c = a xor b
	while (c != 0) {
		count++
		c = c and (c - 1)
	}
	return count
}
