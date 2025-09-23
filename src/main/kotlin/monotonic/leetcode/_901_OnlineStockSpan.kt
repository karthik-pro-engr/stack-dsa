package monotonic.leetcode

class StockSpanner {

    val stack = ArrayDeque<Pair<Int, Int>>()

    fun next(price: Int): Int {

        println("after adding price-> $price")
        var span = 1

        while (stack.isNotEmpty() && stack.last().first <= price) {
            val (_, prevSpan) = stack.removeLast()
            span += prevSpan
        }
        stack.addLast(price to span)


        return span
    }

}

fun main() {
    val stockSpanner = StockSpanner()
    println(stockSpanner.next(100)) // return 1


    println(stockSpanner.next(80)) // return 1

    println(stockSpanner.next(60)) // return 1

    println(stockSpanner.next(70)) // return 2

    println(stockSpanner.next(60)) // return 1

    println(stockSpanner.next(75)) // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today)'s price.

    println(stockSpanner.next(85)) // return 6


}