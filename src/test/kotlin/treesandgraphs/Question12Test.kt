package treesandgraphs

import bitmanipulation.updateBits
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class Question12Test : FunSpec({
	test("Paths with Sum") {
		val n = "10000000000".toInt(radix = 2)
		val m = "10011".toInt(radix = 2)
		updateBits(n, m, 2, 6).toString(radix = 2) shouldBe "10001001100"
	}
})
