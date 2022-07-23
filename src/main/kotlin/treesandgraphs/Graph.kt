package treesandgraphs

class Graph(val children: Array<Node>)

data class Node(val name: String, val children: List<Node> = emptyList())
