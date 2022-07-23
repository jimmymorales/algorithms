package treesandgraphs

class TreeNode(
	val data: Int,
	left: TreeNode? = null,
	right: TreeNode? = null,
) {
	var parent: TreeNode? = null
	var left: TreeNode? = left
		set(value) {
			field = value
			if (value != null) {
				value.parent = this
			}
		}
	var right: TreeNode? = right
		set(value) {
			field = value
			if (value != null) {
				value.parent = this
			}
		}
	var size: Int = 0
		private set

	fun insertInOrder(d: Int) {
		if (d <= data) {
			if (left == null) {
				left = TreeNode(d)
			} else {
				left?.insertInOrder(d)
			}
		} else {
			if (right == null) {
				right = TreeNode(d)
			} else {
				right?.insertInOrder(d)
			}
		}
		size++
	}
}
