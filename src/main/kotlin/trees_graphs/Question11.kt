package trees_graphs

import java.util.Random

class Tree {
    var root: BstNode? = null
        private set

    val size: Int get() = root?.size ?: 0

    fun insertInOrder(value: Int) {
        if (root == null) {
            root = BstNode(value)
        } else {
            root?.insertInOrder(value)
        }
    }

    fun find(value: Int): BstNode? = root?.find(value)

    fun delete(value: Int) {
        if (root?.data == value && root?.isLeaf() == true) {
            root = null
        } else {
            root?.delete(value)
        }
    }

    fun getRandomNode(): BstNode? {
        if (root == null) return null

        val random = Random()
        val i = random.nextInt(size)
        return root?.getIthNode(i)
    }
}

class BstNode(d: Int) {
    var data: Int = d
        private set
    var size = 1
        private set

    var left: BstNode? = null
        private set
    var right: BstNode? = null
        private set

    fun insertInOrder(value: Int) {
        if (value <= data) {
            if (left == null) {
                left = BstNode(value)
            } else {
                left?.insertInOrder(value)
            }
        } else {
            if (right == null) {
                right = BstNode(value)
            } else {
                right?.insertInOrder(value)
            }
        }
        size++
    }

    fun find(value: Int): BstNode? = when {
        value == data -> this
        value <= data -> left?.find(value)
        else -> right?.find(value)
    }

    fun delete(value: Int) {
        if (value == data) {
            val node = if (left != null) left else right
            if (node != null) {
                data = node.data
                if (node.isLeaf()) {
                    if (node === left) {
                        left = null
                    } else {
                        right = null
                    }
                } else {
                    node.delete(data)
                }
            }
        } else if (value == left?.data && left?.isLeaf() == true) {
            left = null
        } else if (value == right?.data && right?.isLeaf() == true) {
            right = null
        } else if (value < data) {
            left?.delete(value)
        } else {
            right?.delete(value)
        }
    }

    fun getIthNode(i: Int): BstNode? {
        val leftSize = left?.size ?: 0
        return when {
            i < leftSize -> left?.getIthNode(i)
            i == leftSize -> this
            else -> right?.getIthNode(i - leftSize + 1)
        }
    }
}

fun BstNode.isLeaf(): Boolean = left == null && right == null
