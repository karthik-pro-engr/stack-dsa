package monotonic

fun previousGreaterElement(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()
    for (i in 0 until  size ) {
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

fun main() {
    println(previousGreaterElement(intArrayOf(2, 1, 5, 3, 3, 3, 6)).joinToString(","))
}