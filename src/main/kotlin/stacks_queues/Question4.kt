package stacks_queues

class QueueViaStacks<T> {
    private val newestItems = Stack<T>()
    private val oldestItems = Stack<T>()

    fun add(item: T) {
        newestItems.push(item)
    }

    fun remove(): T? {
        shiftItems()
        return oldestItems.pop()
    }

    fun peek(): T? {
        shiftItems()
        return oldestItems.pop()
    }

    fun isEmpty() = newestItems.isEmpty() && oldestItems.isEmpty()

    private fun shiftItems() {
        if (oldestItems.isEmpty()) {
            while (!newestItems.isEmpty()) {
                oldestItems.push(newestItems.pop()!!)
            }
        }
    }
}
