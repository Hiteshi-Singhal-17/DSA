package org.example

/**
 * Remember: Symmetric elements are mirror image of each other.
 */
fun isSymmetricInShape(root: Node?): Boolean {
    if (root == null) return true

    fun isSymmetricHelper(node1: Node, node2: Node): Boolean {
        if (node1.children.size != node2.children.size) return false

        val total = node1.children.size
        val half = (total + 1) / 2 // this works for both!
        for (i in 0 until half) {
            val result = isSymmetricHelper(node1.children[total - 1 - i], node2.children[i])
            if (!result) return false
        }
        return true
    }

    return isSymmetricHelper(root, root)
}