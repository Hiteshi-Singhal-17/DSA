package org.example

data class NodeLevelPair(val node: Node, val level: Int)

// Using two queues
fun levelOrderLineWise2Queue(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    val output = StringBuilder()
    var cLevel = ArrayDeque<Node>()
    var nLevel = ArrayDeque<Node>()
    cLevel.add(node)

    while (cLevel.isNotEmpty()) {
        val cNode = cLevel.removeFirst()
        cNode.children.forEach {
            nLevel.add(it)
        }

        output.append("${cNode.data} ")
        if (cLevel.isEmpty()) {
            cLevel = nLevel
            nLevel = ArrayDeque()

            output.append("\n")
        }
    }
    println(output)
}

// Using one queue and a delimiter
fun levelOrderLineWiseUsingDelimiter(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    val result = StringBuilder()
    val queue = ArrayDeque<Node?>()
    queue.add(node)
    queue.add(null) // indicates level is over.

    while (queue.isNotEmpty()) {
        val cNode = queue.removeFirst()
        if (cNode == null) {
            if (queue.isNotEmpty()) { // otherwise infinite loop
                queue.add(null)
                result.append("\n")
            }
        } else {
            cNode.children.forEach {
                queue.add(it)
            }
            result.append("${cNode.data} ")
        }
    }
    println(result)
}

// Using one queue and count
fun levelOrderLineWiseUsingCount(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    val queue = ArrayDeque<Node>().apply { add(node) }
    val result = StringBuilder()
    var cLevelSize = 1

    while (queue.isNotEmpty()) {
        var i = 0
        while (i != cLevelSize) {
            ++i
            val cNode = queue.removeFirst()
            cNode.children.forEach {
                queue.add(it)
            }
            result.append("${cNode.data} ")
        }
        result.append("\n")
        cLevelSize = queue.size
    }
    println(result)
}

// Using Pair
fun levelOrderLineWiseUsingPair(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    val queue = ArrayDeque<NodeLevelPair>(). apply { add(NodeLevelPair(node,1)) }
    val result = StringBuilder()

    while (queue.isNotEmpty()) {
        val (cNode, cLevel) = queue.removeFirst()
        cNode.children.forEach {
            queue.add(NodeLevelPair(it, cLevel + 1))
        }
        result.append("${cNode.data} ")

        if (cLevel != queue.firstOrNull()?.level) result.append("\n")
    }
    println(result)
}




























