package org.example

class StackPair {
    private val st = ArrayList<Pair<Node, Int>>()
    fun push(node: Node, state: Int) = st.add(Pair(node, state))
    fun pop() = st.removeLast()
    fun isNotEmpty() = st.isNotEmpty()
}

fun iterativeTraversal(root: Node?) {
    if (root == null) {
        println("Tree is empty")
        return
    }

    val st = StackPair()
    st.push(root, 0)

    val preOrder = StringBuilder().apply { append("${root.data} ") }
    val postOrder = StringBuilder()

    while (st.isNotEmpty()) {
        val (parent, idx) = st.pop()
        val child = parent.children.getOrNull(idx)

        if (child != null) {
            st.push(parent, idx + 1)
            st.push(child, 0)
            preOrder.append("${child.data} ")
        } else {
            postOrder.append("${parent.data} ")
        }
    }

    println("Preorder: $preOrder")
    println("Postorder: $postOrder")
}


/**
 * How is above code working ?
 * The state (idx) represents the index of the next child of the current node (parent) to be processed.
 * If the child exists at the current index (idx), the following steps are performed:
 * 1. The current node (parent) is pushed back onto the stack with an incremented state (idx + 1).
 * 2. The child node is pushed onto the stack with an initial state of 0.
 * 3. The child node's data is appended to the preOrder sequence.
 * 4. If no child exists at the current index (idx), it means all children of the current node
 *    have been processed, and the node's data is appended to the postOrder sequence.
 */