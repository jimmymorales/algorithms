package treesandgraphs

private fun validateBST(node: TreeNode): Boolean {
	return checkBST(node)
}

private fun checkBST(node: TreeNode?, min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Boolean = when {
	node == null -> true
	node.data <= min || node.data > max -> false
	else -> checkBST(node.left, min, max = node.data) && checkBST(node.right, min = node.data, max)
}
