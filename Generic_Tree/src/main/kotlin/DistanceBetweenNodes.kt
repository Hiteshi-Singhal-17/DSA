package org.example

fun distanceBetweenNodes(d1: Int, d2: Int, node: Node?): Int {
    val path1 = nodeToRootPath(node, d1)
    val path2 = nodeToRootPath(node, d2)
    if (path1.isEmpty() || path2.isEmpty()) return Int.MAX_VALUE

    var i1 = path1.lastIndex
    var i2 = path2.lastIndex

    while (i1 >= 0 && i2 >= 0 && path1[i1] == path2[i2]) {
        i1--
        i2--
    }

    return i1 + i2 + 2
}