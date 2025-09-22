package monotonic.drills

/***
 * Previous Smaller Element (PSE)
 *
 * Problem statement and explanation:
 * [previous-smaller-element.md](https://github.com/karthik-pro-engr/stack-dsa/blob/main/problems/patterns/monotonic/previous-smaller-element.md)
 *
 * Related Stack tricks and notes
 * [stack-tricks.md](https://github.com/karthik-pro-engr/stack-dsa/blob/main/cheatsheets/stack-tricks.md)
 *
 */
fun previousSmallerElementLeftToRight(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()

    for (i in 0 until size) {
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

fun previousSmallerElementRightToLeft(input: IntArray): IntArray {
    val size = input.size
    val output = IntArray(size) { -1 }
    val stack = mutableListOf<Int>()

    for (i in size - 1 downTo 0) {
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
    println("Left To Right ${previousSmallerElementLeftToRight(intArrayOf(2, 1, 5, 3, 3, 3, 6)).joinToString(",")}")
    println("Right To Left ${previousSmallerElementRightToLeft(intArrayOf(2, 1, 5, 3, 3, 3, 6)).joinToString(",")}")
}