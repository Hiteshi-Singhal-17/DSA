package org.example

private var floor = Int.MIN_VALUE
fun kLargestElement(node: Node?, k: Int): Int? {
    if (node == null) {
        println("Tree is empty")
        return null
    }

    var iValue = Int.MAX_VALUE
    repeat(k) {
        findFloor(node, iValue)
        iValue = floor
        floor = Int.MIN_VALUE
    }
    return if(iValue == Int.MIN_VALUE) null else iValue // if k > size of tree.
}

fun findFloor(node: Node, element: Int) {
    if (node.data in floor until element)
        floor = node.data

    node.children.forEach {
        findFloor(it, element)
    }
}
