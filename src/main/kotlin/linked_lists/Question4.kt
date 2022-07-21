package linked_lists

private fun LinkedListNode<Int>.partition(n: Int): LinkedListNode<Int> {
    var head = this
    var tail = this
    var current = next

    while (current != null) {
        val next = current.next
        if (current.data < n) {
            current.next = head
            head = current
        } else {
            tail.next = current
            tail = current
        }
        current = next
    }
    tail.next = null
    return head
}