package trees_graphs

import java.util.LinkedList

private fun createLevelLinkedList(root: BTNode?): List<LinkedList<BTNode>> {
    val result = mutableListOf<LinkedList<BTNode>>()
    var current = LinkedList<BTNode>()
    if (root != null) {
        current.add(root)
    }
    while(current.isNotEmpty()) {
        result.add(current)
        val parents = current
        current = LinkedList()
        for (parent in parents) {
            if (parent.left != null) {
                current.add(parent.left)
            }
            if (parent.right != null) {
                current.add(parent.right)
            }
        }
    }
    return result
}
