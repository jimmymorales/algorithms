package stacks_queues

class SetOfStacks<T>(private val threshold: Int) : Stack<T> {
    private val stacks = mutableListOf<StackSize<T>>()

    override fun pop(): T? {
        val value = stacks.lastOrNull()?.pop()
        if (stacks.lastOrNull()?.isEmpty() == true) {
            stacks.removeLast()
        }
        return value
    }

    fun popAt(index: Int): T? = stacks.getOrNull(index)?.pop()

    override fun push(item: T) {
        val lastStack = stacks.lastOrNull()
        if (lastStack == null || lastStack.size == threshold) {
            stacks.add(StackSize())
        }
        stacks.lastOrNull()?.push(item)
    }

    override fun peek(): T? = stacks.lastOrNull()?.peek()

    override fun isEmpty(): Boolean = stacks.isEmpty()
}

class StackSize<T> : Stack<T> {
    private val stack: Stack<T> = Stack()

    var size: Int = 0
        private set

    override fun pop(): T? = stack.pop()?.also { size-- }

    override fun push(item: T) {
        stack.push(item)
        size++
    }

    override fun peek(): T? = stack.peek()

    override fun isEmpty(): Boolean = stack.isEmpty()
}

