package org.example

import kotlin.math.max

fun findMaximum(node: Node?): Int? {
    if (node == null) return null

    var maxTree = node.data
    node.children.forEach { child ->
        val maxChild = findMaximum(child)
        maxTree = max(maxChild!!, maxTree)
    }

    return maxTree
}