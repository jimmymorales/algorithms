package linked_lists

import kotlin.math.abs

private fun <T> findIntersection(list1: LinkedListNode<T>, list2: LinkedListNode<T>): LinkedListNode<T>? {
    var sizeA = 1
    var sizeB = 1
    var currentA: LinkedListNode<T>? = list1
    var currentB: LinkedListNode<T>? = list2
    while (currentA?.next != null || currentB?.next != null) {
        if (currentA?.next != null) {
            sizeA++
            currentA = currentA.next
        }
        if (currentB?.next != null) {
            sizeB++
            currentB = currentB.next
        }
    }
    if (currentA !== currentB) {
        return null
    }

    currentA = if (sizeA > sizeB) list1 else list2
    currentB = if (sizeA <= sizeB) list1 else list2
    
    repeat(abs(sizeA - sizeB)) { currentA = currentA?.next }

    while (currentA !== currentB) {
        currentA = currentA?.next
        currentB = currentB?.next
    }

    return currentA
}