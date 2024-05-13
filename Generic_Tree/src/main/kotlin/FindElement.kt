package org.example

fun findElement(node: Node?, data: Int): Boolean {
    if (node == null ) {
        println("Tree is empty!")
        return false
    }

    if (node.data == data) return true
    node.children.forEach {
        val isPresent = findElement(it, data)
        if (isPresent) return true
    }
    return false
}