package monotonic.drills

fun previousGreaterElementLeftToRight(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()
    for (i in 0 until size) {
        val current = input[i]
        while (stack.isNotEmpty() && input[stack.last()] <= current) {
            stack.removeAt(stack.lastIndex)
        }

        if (stack.isNotEmpty())
            output[i] = input[stack.last()]

        stack.add(i)
    }
    return output
}

fun previousGreaterElementRightToLeft(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()
    for (i in size - 1 downTo 0) {
        val current = input[i]
        while (stack.isNotEmpty() && input[stack.last()] < current) {
            output[stack.last()] = current
            stack.removeAt(stack.lastIndex)
        }
        stack.add(i)
    }
    return output
}


fun main() {
    println("Left To Right-> ${previousGreaterElementLeftToRight(intArrayOf(2, 1, 5, 3, 3, 3, 6)).joinToString(",")}")
    println("Right To Left-> ${previousGreaterElementRightToLeft(intArrayOf(2, 1, 5, 3, 3, 3, 6)).joinToString(",")}")
}