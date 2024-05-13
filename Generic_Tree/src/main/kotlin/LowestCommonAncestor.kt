package org.example

fun lowestCommonAncestor(d1: Int, d2: Int, node: Node?): Int {
    val path1 = nodeToRootPath(node, d1)
    val path2 = nodeToRootPath(node, d2)
    println(path1)
    println(path2)

    if (path1.isEmpty() || path2.isEmpty()) return -1

    var i1 = path1.lastIndex
    var i2 = path2.lastIndex
    while (i1 >= 0 && i2 >= 0 && path1[i1] == path2[i2]) {
        i1 -= 1
        i2 -= 1
    }

    return path1[i1 + 1]
}