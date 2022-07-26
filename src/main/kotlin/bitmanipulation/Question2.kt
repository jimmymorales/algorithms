@file:Suppress("MagicNumber", "ReturnCount")

package bitmanipulation

fun main() {
	println(0.125.printBinary())
}

fun Double.printBinary(): String? {
	if (this <= 0 || this >= 1) return null

	return buildString {
		append('.')
		var num = this@printBinary
		var frac = 0.5
		while (num > 0) {
			if (length > 32) return null

			if (num >= frac) {
				append('1')
				num -= frac
			} else {
				append('0')
			}

			frac /= 2
		}
	}
}
