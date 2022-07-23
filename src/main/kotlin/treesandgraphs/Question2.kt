package treesandgraphs

private fun createMinimalBst(arr: IntArray): TreeNode? = createMinimalBst(arr, start = 0, end = arr.lastIndex)

private fun createMinimalBst(arr: IntArray, start: Int, end: Int): TreeNode? {
	if (start > end) return null

	val middle = (start + end) / 2
	return TreeNode(
		data = arr[middle],
		left = createMinimalBst(arr, start, end = middle - 1),
		right = createMinimalBst(arr, start = middle + 2, end),
	)
}
