package linked_lists

private fun <T> kthToLast(head: LinkedListNode<T>, k: Int): LinkedListNode<T>? {
    if (k < 1) return null

    var p1: LinkedListNode<T>? = head
    var p2: LinkedListNode<T>? = p1
    repeat(k) {
        if (p2 == null) return null
        p2 = p2?.next
    }

    while (p2 != null) {
        p2 = p2?.next
        p1 = p1?.next
    }
    return p1
}

// Recursion
private fun <T> kthToLastRec(head: LinkedListNode<T>, k: Int): LinkedListNode<T>? {
    return kthToLastRecHelper(head, k).first
}

private fun <T> kthToLastRecHelper(head: LinkedListNode<T>?, k: Int): Pair<LinkedListNode<T>?, Int> {
    if (head == null) {
        return null to 0
    }

    val (node, pos) = kthToLastRecHelper(head.next, k)
    val index = pos + 1
    return if (index == k) {
        head to index
    } else {
        node to index
    }
}