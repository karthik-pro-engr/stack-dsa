package monotonic.leetcode

/**
 * Leetcode problem- https://leetcode.com/problems/next-greater-element-i/
 */
fun nextGreaterElementWithTwoArraysRightToLeftMyOwnVersion(nums1: IntArray, nums2: IntArray): IntArray {
    val size = nums1.size
    val output = IntArray(size) { -1 }

    val map = HashMap<Int, Int>()
    val stack = mutableListOf<Int>()


    for (i in nums1.indices) {
        map[nums1[i]] = i
    }

    for (i in nums2.size - 1 downTo 0) {
        val current = nums2[i]
        while (stack.isNotEmpty() && nums2[stack.last()] <= current) {
            stack.removeAt(stack.lastIndex)
        }
        if (map.containsKey(current) && stack.isNotEmpty()) {
            output[map[current]!!] = nums2[stack.last()]
        }

        stack.add(i)
    }



    return output
}


fun ngeLeftToRight(nums1: IntArray, nums2: IntArray): IntArray {
    val outputMap = mutableMapOf<Int, Int>()
    val stack = mutableListOf<Int>()

    for (i in nums2.indices) {
        val current = nums2[i]
        while (stack.isNotEmpty() && nums2[stack.last()] < current) {
            outputMap[nums2[stack.last()]] = current
            stack.removeAt(stack.lastIndex)
        }

        stack.add(i)

    }

    return nums1.map { outputMap[it] ?: -1 }.toIntArray()
}

fun nextGreaterElementWithTwoArraysOptimizedVersion(nums1: IntArray, nums2: IntArray): IntArray {

    val stack = mutableListOf<Int>()
    val nums2Map = mutableMapOf<Int, Int>()

    for (i in nums2.size - 1 downTo 0) {
        val current = nums2[i]
        while (stack.isNotEmpty() && stack.last() <= current) {
            stack.removeAt(stack.lastIndex)
        }
        if (stack.isNotEmpty()) {
            nums2Map[current] = stack.last()
        }

        stack.add(current)
    }



    return nums1.map { nums2Map[it] ?: -1 }.toIntArray()
}

fun main() {
    println(
        "Right To Left input array 1-> [4, 1, 2], array 2-> [1, 3, 4, 2] and the answer is -> ${
            nextGreaterElementWithTwoArraysOptimizedVersion(
                intArrayOf(4, 1, 2),
                intArrayOf(1, 3, 4, 2)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array 1-> [2, 4], array 2-> [1, 2, 3, 4] and the answer is -> ${
            nextGreaterElementWithTwoArraysOptimizedVersion(
                intArrayOf(2, 4),
                intArrayOf(1, 2, 3, 4)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array 1-> [5], array 2-> [1, 2, 3, 4] and the answer is -> ${
            nextGreaterElementWithTwoArraysOptimizedVersion(
                intArrayOf(5),
                intArrayOf(1, 2, 3, 4)
            ).joinToString(",")
        }"
    )
    println("\n --------------------------------------------------------------------------------------------\n")
    println(
        "Left To Right input array 1-> [4, 1, 2], array 2-> [1, 3, 4, 2] and the answer is -> ${
            ngeLeftToRight(
                intArrayOf(4, 1, 2),
                intArrayOf(1, 3, 4, 2)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array 1-> [2, 4], array 2-> [1, 2, 3, 4] and the answer is -> ${
            ngeLeftToRight(
                intArrayOf(2, 4),
                intArrayOf(1, 2, 3, 4)
            ).joinToString(",")
        }"
    )
    println(
        "Left to Right input array 1-> [5], array 2-> [1, 2, 3, 4] and the answer is -> ${
            ngeLeftToRight(
                intArrayOf(5),
                intArrayOf(1, 2, 3, 4)
            ).joinToString(",")
        }"
    )
}