# Stack Tricks & Patterns

## Common Stack Patterns

<details>
<summary> <strong>Basics</strong> </summary>

1. **Reverse a String**
    - Push all characters onto a stack
    - Pop all characters to build the reversed string
    - Use `StringBuilder` or `CharArray` for efficiency


2. **Valid Parentheses**
    - Push opening brackets
    - Pop and match closing brackets
    - Stack empty at the end → valid


3. **Min Stack**
    - Maintain auxiliary stack to track minimum
    - Push/pop in sync with main stack


4. **Remove All Adjacent Duplicates**
    - Iterate over characters
    - If stack top equals current character → pop (remove duplicate)
    - Else → push character
    - Rebuild string from stack at the end

</details>

<details>
<summary> <strong>Patterns</strong> </summary>
<details>
<summary><strong>Monotonic</strong></summary>

1. **Next Greater Element (NGE)**  
   - Traverse array from right to left
   - Maintain **monotonic decreasing stack** (store indices or values)
   - While stack top ≤ current element → pop
   - If stack not empty → top is the next greater
   - Else → answer is `-1`  

</details>

</details>