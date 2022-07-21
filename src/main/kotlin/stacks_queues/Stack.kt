package stacks_queues

interface Stack<T> {
    fun pop(): T?
    fun push(item: T)
    fun peek(): T?
    fun isEmpty(): Boolean
}

fun <T> Stack(): Stack<T> = StackImpl()

class StackImpl<T> : Stack<T> {
    private var top: StackNode<T>? = null

    override fun pop(): T? = (top?.data)?.also { top = top?.next }

    override fun push(item: T) {
        top = StackNode(item, next = top)
    }

    override fun peek(): T? = top?.data

    override fun isEmpty() = top == null

    private class StackNode<T>(val data: T, var next: StackNode<T>? = null)
}
