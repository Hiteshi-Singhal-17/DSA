package org.example

fun levelOrderTraversal(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    val result = StringBuilder()
    val queue = ArrayDeque<Node>()
    queue.add(node)

    while (queue.isNotEmpty()) {
        val cNode = queue.removeFirst()
        cNode.children.forEach {
            queue.add(it)
        }
        result.append("${cNode.data} ")
    }

    println(result)
}