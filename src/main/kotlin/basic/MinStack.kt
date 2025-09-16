package basic

class MinStack {
    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(x: Int) {
        stack.add(x)
        if (minStack.isEmpty() || x <= minStack.last()) {
            minStack.add(x)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            val popped = stack.removeAt(stack.size - 1)
            if (popped == minStack.last()) {
                minStack.removeAt(minStack.size - 1)
            }
        }
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}