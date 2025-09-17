# 16-sep-2025 : Remove All Adjacent Duplicates

## Problem statement

Given a string s, remove all adjacent duplicates repeatedly until no duplicates remain.

### Example

Input:  "abbaca"
Output: "ca"
Explanation:
- "abbaca" → remove "bb" → "aaca"
- "aaca" → remove "aa" → "ca"

### Constraints:

- 1 ≤ s.length ≤ 10⁵

- s consists of lowercase English letters.


## Notes / Hints
- Use a **stack** to keep track of the last character.
- If the current character equals the stack’s top → pop it (remove duplicate).
- Else → push it into the stack.
- Finally, rebuild the string from the stack. 

### Time Complexity
- Each character is pushed and popped at most once → **O(n)**

### Space Complexity
- Stack may store all characters in worst case → **O(n)**