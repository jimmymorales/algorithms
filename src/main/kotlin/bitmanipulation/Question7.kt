package bitmanipulation

fun main() {
	val a = 234321
	println("$a = ${a.toString(radix = 2)}")
	val b = swapOddEvenBits(a)
	println("$b = ${b.toString(radix = 2)}")
}

private fun swapOddEvenBits(x: Int): Int = (((x and 0xaaaaaaaa.toInt()) ushr 1) or ((x and 0x55555555) shl 1))
