package stacks_queues

class MinStack {
    private var top: StackNode? = null
    private val min = Stack<Int>()

    fun pop(): Int? = (top?.data)?.also { popped ->
        top = top?.next
        if (min.peek() == popped) {
            min.pop()
        }
    }

    fun push(item: Int) {
        top = StackNode(item, next = top)
        val currentMin = min.peek()
        if (currentMin == null || currentMin >= item) {
            min.push(item)
        }
    }

    fun peek(): Int? = top?.data

    fun isEmpty() = top == null

    fun min(): Int? = min.peek()

    private class StackNode(val data: Int, var next: StackNode? = null)
}

