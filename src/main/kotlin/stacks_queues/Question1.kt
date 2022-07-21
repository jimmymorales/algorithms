package stacks_queues

class MultiStack(stackNum: Int, defaultSize: Int = 10) {
    private val values = IntArray(size = stackNum * defaultSize)
    private val info = Array(stackNum) { i -> StackInfo(start = defaultSize * i, capacity = defaultSize) }

    /* Push value onto stack num, shifting/expanding stacks as necessary. Throws exception if all stacks are full. */
    fun push(stackNum: Int, value: Int) {
        if (areAllStacksFull()) {
            throw FullStackException()
        }

        // If this stack is full, expand it. */
        val stack = info[stackNum]
        if (stack.isFull()) {
            expand(stackNum)
        }

        /* Find the index of the top element in the array + 1, and increment the stack pointer. */
        stack.size++
        values[stack.lastElementIndex] = value
    }

    /* Remove value from stack. */
    fun pop(stackNum: Int): Int? {
        val stack = info[stackNum]
        if (stack.isEmpty()) return null

        /* Remove last element. */
        val value = values[stack.lastElementIndex]
        values[stack.lastElementIndex] = 0 // Clear Item
        stack.size-- // Shrink size
        return value
    }

    /* Get top element of stack. */
    fun peek(stackNum: Int): Int = values[info[stackNum].lastElementIndex]

    /* Returns the number of items actually present in the stack */
    private val numberOfElements: Int get() = info.sumOf(StackInfo::size)

    /* Shift items in stack over by one element. If we have available capacity, then we'll end up shrinking the stack by
     * one element. If we don't have available capacity, then we'll need to shift the next stack over too. */
    private fun shift(stackNum: Int) {
        val stack = info[stackNum]

        /* If this stack is at its full capacity, then you need to move the next stack over by one element. This stack
         * can now claim the freed index. */
        if (stack.size >= stack.capacity) {
            val nextStack = (stackNum + 1) % info.size
            shift(nextStack)
            stack.capacity++
        }

        /* Shift all elements in stack over by one. */
        var index = stack.lastCapacityIndex
        while (stack.isWithinStackCapacity(index)) {
            values[index] = values[previousIndex(index)]
            index = previousIndex(index)
        }

        /* Adjust stack data. */
        values[stack.start] = 0 // Clear item
        stack.start = nextIndex(stack.start) // move start
        stack.capacity-- // Shrink capacity
    }

    private fun expand(stackNum: Int) {
        shift((stackNum + 1) % info.size)
        info[stackNum].capacity++
    }

    /* Returns true if all the stacks are full. */
    private fun areAllStacksFull(): Boolean = numberOfElements == values.size

    /* Adjust index to be within the range of 0 -> length - 1. */
    private fun adjustIndex(index: Int): Int = ((index % values.size) + values.size) % values.size

    /* Get index after this index, adjusted for wrap around. */
    private fun nextIndex(index: Int): Int = adjustIndex(index + 1)

    /* Get index before this index, adjusted for wrap around. */
    private fun previousIndex(index: Int): Int = adjustIndex(index - 1)

    /* StackInfo is a simple class that holds a set of data about each stack. It does not hold the actual items in the
     * stack. We could have done this with just a bunch of individual variables, but that's messy and doesn't gain us
     * much. */
    private inner class StackInfo(
        var start: Int,
        var capacity: Int,
    ) {
        var size = 0
    }

    private val StackInfo.lastCapacityIndex: Int get() = adjustIndex(index = start + capacity - 1)
    private val StackInfo.lastElementIndex: Int get() = adjustIndex(index = start + size - 1)
    private fun StackInfo.isEmpty() = size == 0
    private fun StackInfo.isFull() = size == capacity

    /* Check if an index on the full array is within the stack boundaries. The stack can wrap around to the start of
         * the array. */
    private fun StackInfo.isWithinStackCapacity(index: Int): Boolean {
        /* If outside of bounds of array, return false. */
        if (index < 0 || index >= values.size) {
            return false
        }

        /* If index wraps around, adjust it. */
        val contiguosIndex = if (index < start) index + values.size else index
        val end = start + capacity
        return contiguosIndex in start until end
    }
}

class FullStackException : Exception()

