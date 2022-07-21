package linked_lists

private fun <T> LinkedListNode<T>.delete(): Boolean {
    val next = next ?: return false

    data = next.data
    this.next = next.next
    return true
}