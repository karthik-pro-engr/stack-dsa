package basic

fun removeDuplicates(input: String): String {
    val stack = mutableListOf<Char>()
    for (c in input) {
        if (stack.isNotEmpty() && stack.last() == c) {
            stack.removeAt(stack.size - 1)
        } else stack.add(c)
    }
    return stack.joinToString("")
}

fun main() {
    println(removeDuplicates("abbaca"))
    println(removeDuplicates("aaaaaaaa"))
    println("abcdefghijklmnopqrstuvwvw")
}