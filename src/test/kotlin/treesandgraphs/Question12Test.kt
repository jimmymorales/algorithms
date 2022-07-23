package treesandgraphs

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import utils.bstNodeArb

internal class Question12Test : FunSpec({
	test("Paths with Sum") {
		checkAll(bstNodeArb(size = 20), Arb.int(min = -1, max = 100)) { root, targetSum ->
			countPathsWithSum(root, targetSum) shouldBeExactly countPathsWithSumBF(root, targetSum)
		}
	}
})
