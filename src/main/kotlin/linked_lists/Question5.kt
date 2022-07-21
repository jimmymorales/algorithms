package linked_lists

private fun LinkedListNode<Int>.plus(node: LinkedListNode<Int>): LinkedListNode<Int> {
    var n1: LinkedListNode<Int>? = this
    var n2: LinkedListNode<Int>? = node
    val resHead = LinkedListNode(0)
    var current: LinkedListNode<Int>? = null
    var acm = 0
    while (n1 != null || n2 != null) {
        if (current == null) {
            current = resHead
        } else {
            current.next = LinkedListNode(0)
            current = current.next
        }
        val sum = (n1?.data ?: 0) + (n2?.data ?: 0) + acm
        current?.data = if (sum > 9) sum - 10 else sum
        acm = if (sum > 9) 1 else 0
        n1 = n1?.next
        n2 = n2?.next
    }
    if (acm != 0) {
        current?.next = LinkedListNode(acm)
    }
    return resHead
}

private fun LinkedListNode<Int>.plusRec(node: LinkedListNode<Int>): LinkedListNode<Int> {
    return sumHelper(this, node)!!
}

private fun sumHelper(node1: LinkedListNode<Int>?, node2: LinkedListNode<Int>?, carry: Int = 0): LinkedListNode<Int>? {
    if (node1 == null && node2 == null) {
        return null
    }

    val value = carry + (node1?.data ?: 0) + (node2?.data ?: 0)
    return LinkedListNode(value % 10).apply {
        next = sumHelper(node1?.next, node2?.next, if (value > 9) 1 else 0)
    }
}
