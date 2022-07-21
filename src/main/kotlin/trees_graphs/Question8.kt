package trees_graphs

private fun commonAncestor(root: BTNode, p: BTNode, q: BTNode): BTNode? {
    val res = commonAncestorHelper(root, p, q)
    return if (res.second) res.first else null
}

private fun commonAncestorHelper(root: BTNode?, p: BTNode, q: BTNode): Pair<BTNode?, Boolean> {
    if (root == null) return null to false
    if (p === root && q === root) return root to true

    val rx = commonAncestorHelper(root.left, p, q)
    if (rx.second) {
        return rx
    }

    val ry = commonAncestorHelper(root, p, q)
    if (ry.second) {
        return ry
    }

    return if (rx.first != null && ry.first != null) {
        root to true
    } else if (root === p || root === q) {
        val isAncestor = rx.first != null || ry.first != null
        root to isAncestor
    } else {
        val node = if (rx.first != null) rx.first else ry.first
        node to false
    }
}