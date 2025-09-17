# 16-Sep-2025 : Valid Parentheses Using Stack

## Problem Statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine if the input string is **valid**.

A string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

### Example

Input: "({\[]})"
Output: true

Input: "({\[})]"
Output: false

### Constraints

* 1 ≤ s.length ≤ 10^5
* `s` consists only of characters '(', ')', '{', '}', '\[' and ']'.

### Notes

* Use a **stack** to keep track of opening brackets.
* For every closing bracket, check if the **top of the stack** matches.
* If the stack is empty at the end, the string is valid.
* Avoid using regex or built-in matching functions to learn stack logic.

### Approach

1. Initialize an empty stack.
2. Traverse the string character by character.

    * If it's an opening bracket, push onto stack.
    * If it's a closing bracket, check top of stack:

        * If top matches opening bracket, pop it.
        * Otherwise, return false immediately.
3. After traversal, if the stack is empty → return true, else false.

### Time Complexity

* Each character is pushed/popped at most once → O(n)

### Space Complexity

* Stack stores opening brackets → O(n)
