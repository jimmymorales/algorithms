package treesandgraphs

@Suppress("MagicNumber")
fun main() {
	val root = TreeNode(
		data = 5,
		left = TreeNode(
			data = 3,
			left = TreeNode(-8),
			right = TreeNode(8)
		),
		right = TreeNode(
			data = 1,
			left = TreeNode(
				data = 2,
				left = TreeNode(0)
			),
			right = TreeNode(6)
		)
	)

	println(countPathsWithSumBF(root, targetSum = 0))
	println(countPathsWithSum(root, targetSum = 0))
}

/* BRUTE FORCE SOLUTION */
/* O(n log n) */
fun countPathsWithSumBF(root: TreeNode?, targetSum: Int): Int {
	if (root == null) return 0

	val pathsFromRoot = countPathsWithSumFromNode(root, targetSum, currentSum = 0)

	val pathsOnLeft = countPathsWithSumBF(root.left, targetSum)
	val pathsOnRight = countPathsWithSumBF(root.right, targetSum)

	return pathsFromRoot + pathsOnLeft + pathsOnRight
}

private fun countPathsWithSumFromNode(node: TreeNode?, targetSum: Int, currentSum: Int): Int {
	if (node == null) return 0

	val newCurrentSum = currentSum + node.data
	var totalPaths = 0
	if (newCurrentSum == targetSum) {
		totalPaths++
	}

	totalPaths += countPathsWithSumFromNode(node.left, targetSum, newCurrentSum)
	totalPaths += countPathsWithSumFromNode(node.right, targetSum, newCurrentSum)

	return totalPaths
}

/* OPTIMIZED SOLUTION */
/* O(n) */
fun countPathsWithSum(root: TreeNode?, targetSum: Int): Int {
	return countPathsWithSum(root, targetSum, runningSum = 0, pathCount = mutableMapOf())
}

private fun countPathsWithSum(node: TreeNode?, targetSum: Int, runningSum: Int, pathCount: MutableMap<Int, Int>): Int {
	if (node == null) return 0

	val newRunningSum = runningSum + node.data
	val sum = newRunningSum - targetSum
	var totalPaths = pathCount.getOrDefault(sum, defaultValue = 0)
	if (newRunningSum == targetSum) {
		totalPaths++
	}

	incrementHashTable(pathCount, newRunningSum, delta = 1)
	totalPaths += countPathsWithSum(node.left, targetSum, newRunningSum, pathCount)
	totalPaths += countPathsWithSum(node.right, targetSum, newRunningSum, pathCount)
	incrementHashTable(pathCount, newRunningSum, delta = -1)

	return totalPaths
}

private fun incrementHashTable(map: MutableMap<Int, Int>, key: Int, delta: Int) {
	val newCount = map.getOrDefault(key, defaultValue = 0) + delta
	if (newCount == 0) {
		map.remove(key)
	} else {
		map[key] = newCount
	}
}
