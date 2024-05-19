package org.example

fun nodeMaxSubTreeSum(root: Node?): Pair<Node?, Int?> {
    if (root == null) {
        println("Tree is empty")
        return Pair(null, null)
    }

    var maxNodeSumPair: Pair<Node, Int> = Pair(Node(-1), Int.MIN_VALUE)
    fun helper(node: Node): Int {
        var treeSum = node.data

        node.children.forEach {
            treeSum += helper(it)
        }

        if (treeSum > maxNodeSumPair.second)
            maxNodeSumPair = Pair(node, treeSum)

        return treeSum
    }
    helper(root)
    return maxNodeSumPair
}