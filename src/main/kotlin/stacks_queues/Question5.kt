package stacks_queues

private fun Stack<Int>.sort() {
    val temp = Stack<Int>()
    while (!isEmpty()) {
        val n = pop()!!
        while (!temp.isEmpty() && temp.peek()!! > n) {
            push(temp.pop()!!)
        }
        temp.push(n)
    }

    while (!temp.isEmpty()) {
        push(temp.pop()!!)
    }
}