package org.example

fun isMirrorInShape(node1: Node?, node2: Node?): Boolean {
    if (node1 == null && node2 == null) return true
    if (node1 == null || node2 == null) return false

    if (node1.children.size != node2.children.size) return false

    val count = node1.children.lastIndex
    for (i in 0..count) {
        val result = isMirrorInShape(node1.children[count - i], node2.children[i])
        if (!result) return false
    }

    return true
}