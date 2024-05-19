package org.example

fun findCeilAndFloor(root: Node?, element: Int): Pair<Int?, Int?> {
    if (root == null) return Pair(null, null)

    var ceil = Int.MAX_VALUE
    var floor = Int.MIN_VALUE

    fun helper(node: Node, element: Int) {
        if (node.data in floor..<element) floor = node.data
        else if (node.data in (element + 1)..ceil) ceil = node.data

        node.children.forEach {
            helper(it, element)
        }
    }
    helper(root, element)
    return Pair(ceil, floor)
}