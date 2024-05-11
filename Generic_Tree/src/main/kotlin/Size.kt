package org.example

//var size = 0
fun sizeOfTree(node: Node?): Int {
    if (node == null) return 0
    var count = 1

    node.children.forEach {
        count += sizeOfTree(it)
    }

    return count
}