package monotonic

fun circularNextGreaterElement(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()

    for (i in (size * 2 - 1) downTo 0) {
        val currentIndex = i % size
        val current = input[currentIndex]
        while (stack.isNotEmpty() && input[stack.last()] <= current) {
            stack.removeAt(stack.lastIndex)
        }

        if (i < size && stack.isNotEmpty())
            output[currentIndex] = input[stack.last()]
        stack.add(currentIndex)
    }
    return output
}

fun circularNextGreaterElementLeftToRight(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()

    for (i in 0 until size * 2) {
        val currentIndex = i % size
        val current = input[currentIndex]
        while (stack.isNotEmpty() && input[stack.last()] < current) {
            output[stack.last()] = current
            stack.removeAt(stack.lastIndex)
        }
        if (i < size)
            stack.add(currentIndex)
    }
    return output
}

fun main() {
    println(circularNextGreaterElement(intArrayOf(1, 2, 1)).joinToString(","))
    println(circularNextGreaterElementLeftToRight(intArrayOf(1, 2, 1)).joinToString(","))
}