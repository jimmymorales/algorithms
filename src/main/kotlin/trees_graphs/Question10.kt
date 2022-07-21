package trees_graphs

operator fun BTNode.contains(node: BTNode?): Boolean = if (node == null) true else this.isSubtree(node)

private fun BTNode?.isSubtree(node: BTNode?): Boolean = when {
    this == null -> false
    value == node?.value && matchTrees(this, node) -> true
    else -> left.isSubtree(node) || right.isSubtree(node)
}

private fun matchTrees(t1: BTNode?, t2: BTNode?): Boolean = when {
    t1 == null && t2 == null -> true
    t1?.value != t2?.value -> false
    else -> matchTrees(t1?.left, t2?.left) && matchTrees(t1?.right, t2?.right)
}
