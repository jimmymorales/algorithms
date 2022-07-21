package trees_graphs

fun main() {
    val node = BTNode(
        value = 2,
        left = BTNode(1),
        right = BTNode(3),
    )

    println(allSequences(node))
}

private fun allSequences(root: BTNode?): List<List<Int>> {
    if (root == null) {
        return listOf(emptyList())
    }

    return buildList {
        for (left in allSequences(root.left)) {
            for (right in allSequences(root.right)) {
                addAll(weaveLists(left, right, listOf(root.value)))
            }
        }
    }
}

private fun weaveLists(first: List<Int>, second: List<Int>, prefix: List<Int>): List<List<Int>> {
    if (first.isEmpty() || second.isEmpty()) {
        return listOf(prefix + first + second)
    }

    return buildList {
        addAll(weaveLists(first.drop(1), second, prefix + first.first()))
        addAll(weaveLists(first, second.drop(1), prefix + second.first()))
    }
}