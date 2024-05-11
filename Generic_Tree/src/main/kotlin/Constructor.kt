package org.example
class Stack {
    private val st = ArrayList<Node>()
    fun push(node: Node) = st.add(node)
    fun pop() = st.removeLast()
    fun peek() = st.last()

    val size: Int
        get() = st.size
}

fun createTree(input: IntArray): Node? {
    val st = Stack()
    var root: Node? = null

    for (data in input) {
        val node = Node(data)
        if (st.size == 0) {
            root = node
            st.push(node)
        }
        else {
            if (data == -1) st.pop()
            else {
                st.peek().children.add(node)
                st.push(node)
            }
        }
    }
    return root
}

/**
Iterate through each integer in the input array.
1. If the stack is empty, this means a new subtree or the root is being started.
2. If the integer is -1, pop the stack which means finishing the current node and going back up to its parent.
3. Otherwise, create a new node and push in the stack
*/