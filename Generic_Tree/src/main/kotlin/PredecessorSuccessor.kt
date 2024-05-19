package org.example

fun findPredecessorAndSuccessor(node: Node?, element: Int): Pair<Node?, Node?> {
    if (node == null) return Pair(null, null)

    var predecessor: Node? = null
    var successor: Node? = null
    var flag = false

    fun predecessorSuccessorHelper(node: Node, element: Int) {
        if (node.data == element) flag = true
        else if (flag) {
            successor = node
            return
        } else predecessor = node

        node.children.forEach {
            predecessorSuccessorHelper(it, element)
            if (successor != null) return
        }
    }

    predecessorSuccessorHelper(node, element)
    return if (!flag) Pair(null, null)
    else Pair(predecessor, successor)
}

// Clean and smart
fun findPS(root: Node?, element: Int): Pair<Node?, Node?> {
    if (root == null) return Pair(null, null)
    var predecessor: Node? = null
    var successor: Node? = null
    var state = 0

    fun dfs(node: Node, element: Int) {
        if (state == 0) {
            if (node.data == element) state = 1
            else predecessor = node
        } else if (state == 1) {
            successor = node
            state = 2
        }

        node.children.forEach {
            dfs(it, element)
        }
    }
    dfs(root, element)
    return if (state == 0) Pair(null, null)
    else Pair(predecessor, successor)
}