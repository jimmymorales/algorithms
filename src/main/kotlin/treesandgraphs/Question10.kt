package treesandgraphs

operator fun TreeNode.contains(node: TreeNode?): Boolean = if (node == null) true else this.isSubtree(node)

private fun TreeNode?.isSubtree(node: TreeNode?): Boolean = when {
	this == null -> false
	data == node?.data && matchTrees(this, node) -> true
	else -> left.isSubtree(node) || right.isSubtree(node)
}

private fun matchTrees(t1: TreeNode?, t2: TreeNode?): Boolean = when {
	t1 == null && t2 == null -> true
	t1?.data != t2?.data -> false
	else -> matchTrees(t1?.left, t2?.left) && matchTrees(t1?.right, t2?.right)
}
