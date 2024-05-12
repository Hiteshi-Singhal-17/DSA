package org.example

fun mirrorTheTree(node: Node?) {
    if (node == null) return

    node.children.reverse()
    node.children.forEach {
        mirrorTheTree(it)
    }
}