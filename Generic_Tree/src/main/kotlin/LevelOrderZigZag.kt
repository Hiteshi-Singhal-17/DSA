package org.example

fun LevelOrderZigZag(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    var output = ArrayList<Int>()
    var cLevel = ArrayDeque<Node>()
    var nLevel = ArrayDeque<Node>()
    var flag = true
    cLevel.add(node)

    while (cLevel.isNotEmpty()) {
        val cNode = cLevel.removeFirst()
        cNode.children.forEach {
            nLevel.add(it)
        }
        output.add(cNode.data)

        if (cLevel.isEmpty()) {
            cLevel = nLevel
            nLevel = ArrayDeque()

            println(if (flag) output.joinToString(" ") else output.reversed().joinToString(" "))
            flag = !flag
            output = ArrayList()
        }
    }
}