package bitmanipulation

fun main() {
	val n = "10000000000".toInt(radix = 2)
	val m = "10011".toInt(radix = 2)
	val r = updateBits(n, m, 2, 6) // 10001001100
	println(r.toString(radix = 2))
}

fun updateBits(n: Int, m: Int, i: Int, j: Int): Int {
	if (i > j || i < 0 || j >= MAX) return 0

	val left = if (j < MAX - 1) -1 shl (j + 1) else 0
	val mask = left or ((1 shl i) - 1)
	return (n and mask) or (m shl i)
}

private const val MAX = 32
