package treesandgraphs

private fun TreeNode.inorderSuccessor(): TreeNode? {
	if (right != null) {
		var current = right
		while (current?.left != null) {
			current = current.left
		}
		return current
	}

	var current = this
	var parent = current.parent
	while (parent != null && parent.left !== current) {
		current = parent
		parent = current.parent
	}
	return parent
}
