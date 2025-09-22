package monotonic.leetcode
/**
 * Leetcode problem- https://leetcode.com/problems/next-greater-element-ii/description/
 */
fun circularNextGreaterElementRightToLeft(nums: IntArray): IntArray {
    val size = nums.size
    val output = IntArray(size) { -1 }
    val stack = ArrayDeque<Int>()

    for (i in (size * 2 - 1) downTo 0) {
        val currentIndex = i % size
        val current = nums[currentIndex]

        while (stack.isNotEmpty() && stack.last() <= current) {
            stack.removeLast()
        }

        if (i < size && stack.isNotEmpty()) {
            output[currentIndex] = stack.last()
        }
        stack.add(current)
    }

    return output
}

fun circularNextGreaterElementLeftToRight(nums: IntArray): IntArray {
    val size = nums.size
    val output = IntArray(size) { -1 }
    val stack = ArrayDeque<Int>()

    for (i in 0 until size * 2) {
        val currentIndex = i % size
        val current = nums[currentIndex]
        while (stack.isNotEmpty() && nums[stack.last()] < current) {
            output[stack.last()] = current
            stack.removeLast()
        }

        if (i < size)
            stack.add(i)
    }

    return output
}

fun main() {
    println(
        "Right To Left input array -> [1, 2, 1] and the answer is -> ${
            circularNextGreaterElementRightToLeft(
                intArrayOf(1, 2, 1)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array -> [1, 2, 3,4,3] and the answer is -> ${
            circularNextGreaterElementRightToLeft(
                intArrayOf(1, 2, 3, 4, 3)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array -> [5, 4, 3, 2, 1] and the answer is -> ${
            circularNextGreaterElementRightToLeft(
                intArrayOf(5, 4, 3, 2, 1)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array -> [1,2,1,3] and the answer is -> ${
            circularNextGreaterElementRightToLeft(
                intArrayOf(1, 2, 1, 3)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input array -> [2,1,2,3] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(2, 1, 2, 3)
            ).joinToString(",")
        }"
    )

    println("**************************************************************************")


    println(
        "Right To Left input array -> [2,1,2,3] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(2, 1, 2, 3)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array -> [1, 2, 1] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(1, 2, 1)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array -> [1, 2, 3,4,3] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(1, 2, 3, 4, 3)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array -> [5, 4, 3, 2, 1] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(5, 4, 3, 2, 1)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array -> [1,2,1,3] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(1, 2, 1, 3)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input array -> [2,1,2,3] and the answer is -> ${
            circularNextGreaterElementLeftToRight(
                intArrayOf(2, 1, 2, 3)
            ).joinToString(",")
        }"
    )
}