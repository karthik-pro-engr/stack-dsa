package basic

fun isValidParentheses(input: String): Boolean {
    val stack = mutableListOf<Char>()
    val map = mapOf('(' to ')', '{' to '}', '[' to ']')
    for (c in input) {
        if (c in map.values) {
            stack.add(c)
        } else if (c in map.keys) {
            if (stack.isEmpty() || stack.removeAt(stack.size - 1) != map[c]) return false
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValidParentheses("({[]})")) // true
    println(isValidParentheses("({[})"))  // false
}