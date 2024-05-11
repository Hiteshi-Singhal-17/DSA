package org.example

fun displayTree(node: Node?) {
    if (node == null) return

    println("${node.data} -> ${node.children.map { "${it.data}"}}")
    node.children.forEach { child ->
        displayTree(child)
    }
}