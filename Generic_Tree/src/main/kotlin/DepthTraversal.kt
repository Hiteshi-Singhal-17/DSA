package org.example

fun depthTraversal(node: Node?) {
    if (node == null) {
        print("Tree is empty")
        return
    }

    println("Node Pre ${node.data}")
    node.children.forEach {
        println("Edge pre ${node.data} -- ${it.data}")
        depthTraversal(it)
        println("Edge post ${it.data} -- ${node.data}")
    }
    println("Node Post ${node.data}")
}