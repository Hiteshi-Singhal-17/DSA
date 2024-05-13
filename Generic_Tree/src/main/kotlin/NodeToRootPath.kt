package org.example

fun nodeToRootPath(node: Node?, data: Int): ArrayList<Int>  {
    if (node == null ) {
        println("Tree is empty!")
        return arrayListOf()
    }

    if (node.data == data) {
        return arrayListOf(node.data)
    }

    node.children.forEach {child ->
        val path = nodeToRootPath(child, data)
        if (path.isNotEmpty()) {
            path.add(node.data)
            return path 
        }
    }
    return arrayListOf()
}