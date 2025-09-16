package basic

fun reverseString(input: String): String {
    val stack = mutableListOf<Char>()
    for (c in input) {
        stack.add(c)
    }
    var reversed = StringBuilder()
    while (stack.size > 0) {
        reversed.append(stack.removeAt(stack.size - 1))
    }
    return reversed.toString()
}