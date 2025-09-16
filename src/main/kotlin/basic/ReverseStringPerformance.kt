package basic

import kotlin.system.measureTimeMillis

fun reverseStringWithSB(input: String): String {
    val stack = mutableListOf<Char>()
    input.reversed()
    for (c in input)
        stack.add(c)
    var reversed = StringBuilder()
    while (stack.isNotEmpty()) {
        reversed.append(stack.removeAt(stack.size - 1))
    }
    return reversed.toString()
}

fun reversedStringWithCharArray(input: String): String {
    val stack = mutableListOf<Char>()
    for (c in input)
        stack.add(c)
    var reversed = CharArray(stack.size)
    var i = 0
    while (stack.isNotEmpty()) {
        reversed[i++] = stack.removeAt(stack.size - 1)
    }
    return reversed.toString()
}

fun reversedStringWithStringConcat(input: String): String {
    val stack = mutableListOf<Char>()
    for (c in input)
        stack.add(c)
    var reversed = ""
    var i = 0
    while (stack.isNotEmpty()) {
        reversed += stack.removeAt(stack.size - 1)
    }
    return reversed
}


fun main() {
    val largeString = "a".repeat(100_000) // large string to see performance difference

    val time1 = measureTimeMillis {
        reverseStringWithSB(largeString)
    }
    println("StringBuilder: $time1 ms")

    val time2 = measureTimeMillis {
        reversedStringWithStringConcat(largeString)
    }
    println("String Concatenation: $time2 ms")

    val time3 = measureTimeMillis {
        reversedStringWithCharArray(largeString)
    }
    println("CharArray: $time3 ms")
}