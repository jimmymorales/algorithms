package bigo

/**
 * EXAMPLE 9
 *
 * What is the runtime of the below code?
 * Sumps the values of all the nodes in a balanced binary search tree.
 */
private fun sum(node: Node?): Int {
    if (node == null) {
        return 0
    }
    return sum(node.left) + node.value + sum(node.right)
}

private data class Node(val value: Int, val left: Node?, val right: Node?)

/**
 * ANSWER 👇
 *
 * This will take O(N) time. Even tho there is some recursion going on, the algorithm will go through all the nodes in
 * the tree. If there are N nodes it will take O(N) to go through all the nodes.
 */
