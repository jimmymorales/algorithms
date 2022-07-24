package bitmanipulation

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import treesandgraphs.countPathsWithSum
import treesandgraphs.countPathsWithSumBF
import utils.bstNodeArb

internal class Question1Test : FunSpec({
	test("Insertion") {

		checkAll(bstNodeArb(size = 20), Arb.int(min = -1, max = 100)) { root, targetSum ->
			countPathsWithSum(root, targetSum) shouldBeExactly countPathsWithSumBF(root, targetSum)
		}
	}
})
