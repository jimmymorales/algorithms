package utils

import io.kotest.property.arbitrary.arbitrary
import treesandgraphs.TreeNode
import kotlin.random.nextInt

fun bstNodeArb(size: Int, min: Int = BST_MIN, max: Int = 20) = arbitrary { rs ->
	val d = rs.random.nextInt(min..max)
	val root = TreeNode(d)
	repeat(size) {
		root.insertInOrder(rs.random.nextInt(min..max))
	}
	root
}

private const val BST_MIN = -20
