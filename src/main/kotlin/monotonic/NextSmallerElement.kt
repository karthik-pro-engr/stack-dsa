package monotonic

fun nextSmallerElementRightToLeft(input: IntArray): IntArray {

    val output = IntArray(input.size) { -1 }

    val stack = mutableListOf<Int>()

    for (i in input.size - 1 downTo 0) {
        val current = input[i]
        while (stack.isNotEmpty() && input[stack.last()] >= current) {
            stack.removeAt(stack.lastIndex)
        }
        if (stack.isNotEmpty()) {
            output[i] = input[stack.last()]
        }
        stack.add(i)
    }

    return output
}
fun nextSmallerElementLeftToRight(input: IntArray): IntArray {

    val output = IntArray(input.size) { -1 }

    val stack = mutableListOf<Int>()

    for (i in 0 until input.size - 1) {
        val current = input[i]
        while (stack.isNotEmpty() && input[stack.last()] > current) {
            output[stack.last()] = current
            stack.removeAt(stack.lastIndex)
        }
        stack.add(i)
    }

    return output
}

fun main() {
    println("Right To Left  ${nextSmallerElementRightToLeft(intArrayOf(2,1,5,3,3,3,6)).joinToString(",")}")
    println("Left To Right  ${nextSmallerElementLeftToRight(intArrayOf(2,1,5,3,3,3,6)).joinToString(",")}")
}