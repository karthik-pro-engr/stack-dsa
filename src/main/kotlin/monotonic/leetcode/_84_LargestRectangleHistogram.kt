package monotonic.leetcode

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {

        var res = 0
        val size = heights.size
        val nse = IntArray(size) { size }
        val pse = IntArray(size) { -1 }
        val stack = ArrayDeque<Int>()
        for (i in 0 until size) {
            val current = heights[i]
            while (stack.isNotEmpty() && heights[stack.last()] > current) {
                nse[stack.last()] = i
                stack.removeLast()
            }
            stack.addLast(i)
        }

        stack.clear()

        for (i in 0 until size) {
            while (stack.isNotEmpty() && heights[stack.last()] > heights[i]) {
                stack.removeLast()
            }
            if (stack.isNotEmpty())
                pse[i] = stack.last()

            stack.addLast(i)
        }
        println("NSE-> ${nse.joinToString(",")}")
        println("PSE-> ${pse.joinToString(",")}")

        for (i in 0 until size) {
            var width = nse[i] - pse[i] - 1
            println("nse-> ${nse[i]}, pse-> ${pse[i]} and width-> $width")
            val area = heights[i] * width
            println("height-> ${heights[i]} , area-> $area")
            res = maxOf(area, res)
        }

        return res
    }
}

fun main() {
    println(Solution().largestRectangleArea(intArrayOf()))
}