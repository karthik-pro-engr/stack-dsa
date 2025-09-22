package monotonic.leetcode

fun dailyTemperatures(temperatures: IntArray): IntArray {

    val size = temperatures.size
    val output = IntArray(size) { 0 }

    val stack = ArrayDeque<Int>()

    for (i in size - 1 downTo 0) {
        val current = temperatures[i]
        while (stack.isNotEmpty() && temperatures[stack.last()] <= current) {
            stack.removeLast()
        }

        if (stack.isNotEmpty()) {
            output[i] = stack.last() - i
        }
        stack.addLast(i)
    }

    return output
}

fun dailyTemperaturesLeftToRight(temperatures: IntArray): IntArray {
    val size = temperatures.size
    val output = IntArray(size) { 0 }
    val stack = ArrayDeque<Int>()
    for (i in temperatures.indices) {
        while (stack.isNotEmpty() && temperatures[stack.last()] < temperatures[i]) {
            output[stack.last()] = i - stack.last()
            stack.removeLast()
        }
        stack.addLast(i)
    }
    return output
}

fun main() {
    println(
        "Right To Left input nums-> [73,74,75,71,69,72,76,73] and the answer is -> ${
            dailyTemperatures(
                intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input nums-> [30,40,50,60] and the answer is -> ${
            dailyTemperatures(
                intArrayOf(30, 40, 50, 60)
            ).joinToString(",")
        }"
    )
    println(
        "Right To Left input nums-> [30,60,90] and the answer is -> ${
            dailyTemperatures(
                intArrayOf(30, 60, 90)
            ).joinToString(",")
        }"
    )

    println("****************************************************************************")

    println(
        "Left To Right input nums-> [73,74,75,71,69,72,76,73] and the answer is -> ${
            dailyTemperaturesLeftToRight(
                intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input nums-> [30,40,50,60] and the answer is -> ${
            dailyTemperaturesLeftToRight(
                intArrayOf(30, 40, 50, 60)
            ).joinToString(",")
        }"
    )
    println(
        "Left To Right input nums-> [30,60,90] and the answer is -> ${
            dailyTemperaturesLeftToRight(
                intArrayOf(30, 60, 90)
            ).joinToString(",")
        }"
    )
}

