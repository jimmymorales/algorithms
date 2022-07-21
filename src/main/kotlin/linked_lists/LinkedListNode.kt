package linked_lists

class LinkedListNode<T>(var data: T) {
    var last: LinkedListNode<T>? = null

    constructor(d: T, n: LinkedListNode<T>?, p: LinkedListNode<T>?) : this(d) {
        next = n
        prev = p
    }

    var next: LinkedListNode<T>? = null
        set(n) {
            field = n
            if (this === last) {
                last = n
            }
            if (n != null && n.prev != this) {
                n.prev = this
            }
        }
    var prev: LinkedListNode<T>? = null
        set(p) {
            field = p
            if (p != null && p.next != this) {
                p.next = this
            }
        }

    fun clone(): LinkedListNode<T> = LinkedListNode(data, next?.clone(), null)
}

fun <T> LinkedListNode<T>.count(): Int {
    var length = 0
    var node: LinkedListNode<T>? = this
    while (node != null) {
        length++
        node = node.next
    }
    return length
}