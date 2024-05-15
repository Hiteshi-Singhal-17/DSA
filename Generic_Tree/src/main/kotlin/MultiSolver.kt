package org.example

import kotlin.math.max
import kotlin.math.min

var minValue  = Int.MAX_VALUE
var maxValue = Int.MIN_VALUE
var size = 0
var height = 0
fun multiSolver(node: Node?, depth: Int) {
    if (node == null) return
    size ++
    minValue = min(node.data, minValue)
    maxValue = max(node.data, maxValue)
    height = max(height, depth)

    node.children.forEach {
        multiSolver(it, depth + 1)
    }
}