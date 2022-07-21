package linked_lists

private fun <T> LinkedListNode<T>.isPalindrome(): Boolean {
    val stack = ArrayDeque<T>()
    var slow: LinkedListNode<T>? = this
    var fast: LinkedListNode<T>? = this
    while (fast?.next != null) {
        stack.add(slow!!.data)
        slow = slow.next
        fast = fast.next?.next
    }

    if (fast != null) {
        slow = slow?.next
    }

    while (slow != null) {
        if (stack.removeLast() != slow.data) {
            return false
        }
        slow = slow.next
    }

    return true
}

private fun <T> LinkedListNode<T>.isPalindromeRec(): Boolean {
    return isPalHelper(this, count()).second
}

private fun <T> isPalHelper(head: LinkedListNode<T>?, length : Int): Pair<LinkedListNode<T>?, Boolean> {
    if (head == null || length == 0) {
        return head to true
    }
    if (length == 1) {
        return head.next to true
    }
    
    val (next, isPal) = isPalHelper(head.next, length - 2)
    if (!isPal) {
        return null to false
    }

    return next?.next to (head.data == next?.data)

}


