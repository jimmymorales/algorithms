package bitmanipulation

fun main() {
	val n = 13948
	println(n.toString(radix = 2))
	println(getNext(n).toString(radix = 2))
	println(getPrev(n).toString(radix = 2))
}

private fun getNext(n: Int): Int {
	var c = n
	var c0 = 0
	var c1 = 0
	while (((c and 1) == 0) && c != 0) {
		c0++
		c = c shr 1
	}

	while ((c and 1) == 1) {
		c1++
		c = c shr 1
	}

	if (c0 + c1 == (Int.SIZE_BITS - 1) || c0 + c1 == 0) {
		return -1
	}

	// Arithmetic approach
	// return n + (1 shl c0) + (1 shl (c1 - 1)) - 1

	val p = c0 + c1 // position of rightmost non-trailing zero
	var num = n or (1 shl p) // Flip rightmost non-trailing zero
	num = num and ((1 shl p) - 1).inv() // Clear all bits to the right of p
	return num or ((1 shl (c1 - 1)) - 1) // insert (c1 - 1) ones on the right
}

private fun getPrev(n: Int): Int {
	var c = n
	var c0 = 0
	var c1 = 0
	while ((c and 1) == 1) {
		c1++
		c = c shr 1
	}

	if (c == 0) return -1

	while (((c and 1) == 0) && c != 0) {
		c0++
		c = c shr 1
	}

	// Arithmetic approach
	// return n + (1 shl c1) + (1 shl (c0 - 1)) + 1

	val p = c0 + c1 // position of rightmost non-trailing one
	val num = n and (0.inv() shl (p + 1)) // Clears from bit p onwards
	val mask = (1 shl (c1 + 1)) - 1 // Sequence of (c1 + 1) ones
	return num or (mask shl (c0 - 1))
}
