package treesandgraphs

import kotlin.math.abs

private fun checkHeight(root: TreeNode?): Int {
	if (root == null) return -1

	val leftHeight = checkHeight(root.left)
	if (leftHeight == Int.MIN_VALUE) return leftHeight

	val rightHeight = checkHeight(root.right)
	if (rightHeight == Int.MIN_VALUE) return rightHeight

	val heightDiff = leftHeight - rightHeight
	return if (abs(heightDiff) > 1) Int.MIN_VALUE else leftHeight.coerceAtLeast(rightHeight) + 1
}

private fun TreeNode.isBalanced() = checkHeight(this) != Int.MIN_VALUE
