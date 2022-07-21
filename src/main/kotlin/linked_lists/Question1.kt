package linked_lists

private fun <T> removeDups(head: LinkedListNode<T>) {
    val set = mutableSetOf<T?>()
    var current: LinkedListNode<T>? = head
    while (current != null) {
        val data = current.data

        if (data in set) {
            current.prev?.next = current.next
            current.next?.prev = current.prev
        } else {
            set.add(data)
        }
        current = current.next
    }
}

// if buffer is not allowed
private fun <T> removeDups2(head: LinkedListNode<T>) {
    var current: LinkedListNode<T>? = head
    while (current != null) {
        var other = current.next
        while (other != null) {
            if (current.data == other.data) {
                other.prev?.next = other.next
                other.next?.prev = other.prev
            }
            other = other.next
        }
        current = current.next
    }
}
