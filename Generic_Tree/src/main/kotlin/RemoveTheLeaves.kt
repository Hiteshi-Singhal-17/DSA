package org.example

fun removeLeafNodes(node: Node?) {
    if (node == null || node.children.isEmpty()) return

        // Iterate over the list of children from last to first to safely remove elements
        // needs to be in preorder otherwise will end up with empty tree.
    for (i in node.children.indices.reversed()) {
        val child = node.children[i]
        if (child.children.isEmpty()) {
            node.children.removeAt(i)
        }
    }

    // After handling the current node's immediate children, recurse for deeper nodes.
    node.children.forEach { child ->
        removeLeafNodes(child)
    }
}
