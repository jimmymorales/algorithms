package treesandgraphs

import java.util.LinkedList

private fun createLevelLinkedList(root: TreeNode?): List<LinkedList<TreeNode>> {
	val result = mutableListOf<LinkedList<TreeNode>>()
	var current = LinkedList<TreeNode>()
	if (root != null) {
		current.add(root)
	}
	while (current.isNotEmpty()) {
		result.add(current)
		val parents = current
		current = LinkedList()
		for (parent in parents) {
			val left = parent.left
			if (left != null) {
				current.add(left)
			}
			val right = parent.right
			if (right != null) {
				current.add(right)
			}
		}
	}
	return result
}
