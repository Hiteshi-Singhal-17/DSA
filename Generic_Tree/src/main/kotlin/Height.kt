package org.example

import kotlin.math.max

fun findHeight(node: Node?): Int {
    if (node == null) return -1
    var height = -1

    node.children.forEach { child ->
        val cHeight = findHeight(child)
        height = max(height, cHeight)
    }

    return height + 1
}