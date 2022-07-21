package trees_graphs

fun main() {
    val orderBuild1 = findBuildOrder(
        projects = setOf("a", "b", "c", "d", "e", "f"),
        dependencies = setOf("a" to "d", "f" to "b", "b" to "d", "f" to "a", "d" to "c"),
    )
    assert(orderBuild1 == listOf("e", "f", "b", "a", "d", "c"))

    val orderBuild2 = findBuildOrder(
        projects = setOf("a", "b", "c", "d", "e", "f", "g"),
        dependencies = setOf(
            "a" to "e",
            "f" to "c",
            "b" to "a",
            "f" to "b",
            "d" to "g",
            "b" to "e",
            "c" to "a",
            "f" to "a",
        ),
    )
    assert(orderBuild2 == listOf("d", "g", "f", "b", "c", "a", "e"))
}

private fun findBuildOrder(projects: Set<String>, dependencies: Set<Pair<String, String>>): List<String>? {
    val projectsLeft = projects.toMutableSet()
    val graph = buildGraph(dependencies, projectsLeft) ?: return null
    val result = ArrayDeque<String>(projects.size)
    val visiting = mutableSetOf<String>()
    val visited = mutableSetOf<String>()

    while (graph.isNotEmpty()) {
        val node = graph.keys.first()
        val res = doDFS(node, visiting, visited, result, graph)
        if (!res) return null
    }

    projectsLeft.forEach(result::addFirst)

    return result.toList()
}

private fun buildGraph(
    dependencies: Set<Pair<String, String>>,
    projects: MutableSet<String>
): MutableMap<String, List<String>>? {
    val graph = mutableMapOf<String, List<String>>()
    for (dep in dependencies) {
        if (dep.first == dep.second) return null
        val deps = graph.getOrElse(dep.first) { emptyList() }
        graph[dep.first] = deps + dep.second
        projects.remove(dep.first)
        projects.remove(dep.second)
    }
    return graph
}

private fun doDFS(
    node: String,
    visiting: MutableSet<String>,
    visited: MutableSet<String>,
    results: ArrayDeque<String>,
    graph: MutableMap<String, List<String>>
): Boolean {
    if (node in visited) return true
    if (node in visiting) return false
    visiting.add(node)
    if (node !in graph) {
        results.addFirst(node)
        visited.add(node)
        return true
    }
    for (dep in graph[node]!!) {
        val res = doDFS(dep, visiting, visited, results, graph)
        if (!res) return false
    }
    results.addFirst(node)
    visited.add(node)
    graph.remove(node)
    return true
}
