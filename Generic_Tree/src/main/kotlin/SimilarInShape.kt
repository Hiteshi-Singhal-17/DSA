package org.example

fun similarInShape(root1: Node?, root2: Node?): Boolean {
    if (root1 == null && root2 == null) return true
    if (root1 == null || root2 == null) return false

    if (root1.children.size != root2.children.size) return false

    for (idx in root1.children.indices) {
        val areSimilar = similarInShape(root1.children[idx], root2.children[idx])
        if (!areSimilar) return false
    }

    return true
}