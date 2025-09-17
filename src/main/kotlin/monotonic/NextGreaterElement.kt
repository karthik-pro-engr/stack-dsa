package monotonic

fun nextGreaterElement(input: IntArray): IntArray {
    val output = IntArray(input.size) { -1 }
    val size = input.size - 1
    val stack = mutableListOf<Int>()
    for (i in size downTo 0) {
        var current = input[i]
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

fun main() {
    println(nextGreaterElement(intArrayOf(2, 1, 5, 3, 6)).joinToString(","))
}