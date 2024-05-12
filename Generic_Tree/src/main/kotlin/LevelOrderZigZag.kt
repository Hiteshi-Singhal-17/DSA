package org.example


fun levelOrderZigZag(node: Node?) {
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

fun levelOrderZigZag2Stacks(node: Node?) {
    if (node == null) {
        println("Tree is empty")
        return
    }

    var cLevel = Stack()
    var nLevel = Stack()
    cLevel.push(node)
    var level = 0

    while (cLevel.size != 0) {
        val cNode = cLevel.pop()

        if (level == 0) {
            cNode.children.forEach {
                nLevel.push(it)
            }
        }
        else {
            for (i in cNode.children.lastIndex downTo  0) {
                nLevel.push(cNode.children[i])
            }
        }

        print("${cNode.data} ")

        if (cLevel.size == 0) {
            cLevel = nLevel
            nLevel = Stack()
            level = if (level == 0) 1 else 0
            println()
        }
    }

}