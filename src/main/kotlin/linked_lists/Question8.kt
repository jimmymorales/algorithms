package linked_lists

fun <T> LinkedListNode<T>.findBeginning(): LinkedListNode<T>? {
    var fast: LinkedListNode<T>? = this
    var slow: LinkedListNode<T>? = this
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) break
    }

    if (fast == null) {
        return null
    }

    slow = this
    while (slow !== fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return fast
}