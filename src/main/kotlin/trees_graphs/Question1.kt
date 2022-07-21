package trees_graphs

private fun Graph.searchPath(start: Node, end: Node): Boolean {
    if (start == end) return true

    val queue = ArrayDeque<Node>().apply { add(start) }
    val visited = mutableSetOf<String>().apply { add(start.name) }

    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        for (child in node.children) {
            if (child.name in visited) continue
            if (child == end) return true
            visited.add(child.name)
            queue.add(child)
        }
    }

    return false
}
