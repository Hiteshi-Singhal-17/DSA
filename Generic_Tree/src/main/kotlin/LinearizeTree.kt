package org.example
fun linearizeTree(node: Node?): Node  {
    if (node == null) {
        println("Tree is empty!")
        return Node(-1) // look into this
    }

    val childLeafNodes = ArrayList<Node>()
    node.children.forEach {
        val leaf = linearizeTree(it)
        childLeafNodes.add(leaf)
    }

    for (idx in node.children.lastIndex downTo 1) {
        val cNode = node.children[idx]
        val pLeafNode = childLeafNodes[idx - 1] //previous leaf node

        pLeafNode.children.add(cNode)
        node.children.remove(cNode)
    }

    // Returning the last leaf node of the tree.
    return if (childLeafNodes.isNotEmpty()) childLeafNodes.last() else node
}

fun linearizeTreeEfficient(node: Node?): Node {
    if (node == null) {
        println("Tree is empty!")
        return Node(-1) // look into this
    }

    if (node.children.isEmpty()) return node

    val lChildEnd = linearizeTreeEfficient(node.children.last())
    while (node.children.size > 1) {
        val lChild = node.children.removeLast()
        val slChild = node.children.last()
        val slChildEnd = linearizeTreeEfficient(slChild)
        slChildEnd.children.add(lChild)
    }
    return lChildEnd
}