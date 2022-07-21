package trees_graphs

private fun validateBST(node: BTNode): Boolean {
    return checkBST(node)
}

private fun checkBST(node: BTNode?, min: Int = Int.MIN_VALUE, max: Int = Int.MAX_VALUE): Boolean = when {
    node == null -> true
    node.value <= min || node.value > max -> false
    else -> checkBST(node.left, min, max = node.value) && checkBST(node.right, min = node.value, max)
}