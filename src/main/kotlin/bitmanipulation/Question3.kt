package bitmanipulation

fun main() {
	println(longestSequence(1_775))
}

fun longestSequence(n: Int): Int {
	if (n.inv() == 0) return Int.SIZE_BITS

	var currentCount = 0
	var previousCount = 0

	var max = 0
	for (i in (Int.SIZE_BITS - 1) downTo 0) {
		if (n.getBit(i)) {
			currentCount++
			previousCount++
		} else {
			if (currentCount > max) {
				max = currentCount
			}
			currentCount = previousCount + 1
			previousCount = 0
		}
	}
	if (currentCount > max) {
		max = currentCount
	}
	return max
}

private fun Int.getBit(index: Int): Boolean = this and (1 shl index) != 0
