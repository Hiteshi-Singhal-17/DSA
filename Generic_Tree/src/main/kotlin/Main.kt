package org.example

data class Node(var data: Int) {
    val children = ArrayList<Node>()
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val input =
        intArrayOf(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1)
    val root = createTree(input)

    val input2 = intArrayOf(10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, 130, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1)
    val root2 = createTree(input2)

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
//    println("Mirror the tree")
//    mirrorTheTree(root)
//    displayTree(root)
//    println("---------------")
//    println("Remove leaf nodes")
//    removeLeafNodes(root)
//    displayTree(root)
//    println("---------------")
//    println("Linearize a tree")
//    linearizeTree(root)
//    displayTree(root)
//    println("---------------")
//    println("Linearize a tree efficient")
//    linearizeTreeEfficient(root)
//    displayTree(root)
//    println("---------------")
    println("Is 110 present in tree ?")
    println(if (findElement(root, 110)) "Present" else "Absent")
    println("---------------")
    println("If 110 present, give path ?")
    println(nodeToRootPath(root, 110)).let(::println)
    println("---------------")
    println("Find lowest common ancestor of 110 and 20")
    println(lowestCommonAncestor(110, 40, root))
    println("---------------")
    println("Distance between node in terms of edges")
    println(distanceBetweenNodes(100, 50, root))
    println("---------------")
    println("Are trees similar in shape")
    println(similarInShape(root, root2))
    println("---------------")
}
