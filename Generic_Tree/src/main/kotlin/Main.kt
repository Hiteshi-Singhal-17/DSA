package org.example

data class Node(var data: Int) {
    val children = ArrayList<Node>()
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val input = intArrayOf(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1)
    val root = createTree(input)
    println("---------------")
    println("Display Tree")
    displayTree(root)
    println("---------------")
    println("Size of Tree")
    sizeOfTree(root).let(::println)
    println("---------------")
    println("Maximum in Tree")
    findMaximum(root).let(::println)
    println("---------------")
    println("Height of Tree w.r.t. edges")
    findHeight(root).let(::println)
    println("---------------")
    println("Euler/DF Traversal of tree")
    depthTraversal(root)
    println("---------------")
    println("BF/Level order of tree")
    levelOrderTraversal(root)
    println("---------------")
    println("BF/Level order of tree using delimiter")
    levelOrderLineWiseUsingDelimiter(root)
    println("---------------")
    println("BF/Level order of tree using count")
    levelOrderLineWiseUsingCount(root)
    println("---------------")
    println("BF/Level order of tree using pair")
    levelOrderLineWiseUsingPair(root)
    println("---------------")
    println("BF/Level order line wise using 2 queues")
    levelOrderLineWise2Queue(root)
    println("---------------")
    println("BF/Level order zig zag of tree")
    levelOrderZigZag(root)
    println("---------------")
    println("BF/Level order zig zag of tree using 2 stacks")
    levelOrderZigZag2Stacks(root)
    println("---------------")

}
