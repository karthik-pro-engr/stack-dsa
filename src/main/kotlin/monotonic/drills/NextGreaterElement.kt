package monotonic.drills

fun nextGreaterElementRightToLeft(input: IntArray): IntArray {
    val output = IntArray(input.size) { -1 }
    val size = input.size - 1
    val stack = mutableListOf<Int>()
    for (i in size downTo 0) {
        val current = input[i]
        while (stack.isNotEmpty() && input[stack.last()] <= current) {
            stack.removeAt(stack.lastIndex)
        }

        if (stack.isNotEmpty()) {
            output[i] = input[stack.last()]
        }
        stack.add(i)
    }

    return output
}

fun nextGreaterElementLeftToRight(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()
    for (i in 0 until size) {
        while (stack.isNotEmpty() && input[stack.last()] < input[i]) {
            output[stack.last()] = input[i]
            stack.removeAt(stack.lastIndex)
        }
        stack.add(i)
    }
    return output
}

fun main() {
    println(nextGreaterElementRightToLeft(intArrayOf(2, 1, 5, 3, 6)).joinToString(","))
    println(nextGreaterElementLeftToRight(intArrayOf(2, 1, 5, 3, 6)).joinToString(","))
}