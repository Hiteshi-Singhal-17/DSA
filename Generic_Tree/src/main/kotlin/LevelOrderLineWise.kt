package org.example

fun LevelOrderLineWise(node: Node?) {
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