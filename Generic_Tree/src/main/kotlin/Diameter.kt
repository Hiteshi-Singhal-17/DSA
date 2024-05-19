package org.example

import kotlin.math.max
// Return -> maxDepth, computing maxDiameter in postOrder.
fun findDiameter(root: Node?): Int {
    if (root == null) {
        println("Tree is empty!")
        return -1
    }
    var maxDiameter = -1

    fun helper(node: Node): Int {
        var m1 = 0
        var m2 = 0
        node.children.forEach {
            val childDepth = helper(it) + 1

            if (childDepth > m1) {
                m2 = m1
                m1 = childDepth
            } else if (childDepth > m2) {
                m2 = childDepth
            }
        }

        if (m1 != 0 && m2 != 0) maxDiameter = max(maxDiameter, m1 + m2)
        return m1
    }
    helper(root)
    return maxDiameter
}