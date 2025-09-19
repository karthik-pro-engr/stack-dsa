# Stack Tricks & Patterns

## Common Stack Patterns

<details open>
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

---

<details open>
<summary> <strong>Patterns</strong> </summary>
<details open>
<summary><strong>Monotonic</strong></summary>

1. **Next Greater Element (NGE)**

   🔹 **Right to Left Approach (Decreasing Stack)**  
   - Traverse array from **right to left**
   - Maintain **monotonic decreasing stack** (store indices or values)
   - While stack top ≤ current element → pop
   - If stack not empty → top is the next greater
   - Else → answer is `-1`

   🔹 **Left to Right Approach (Pop Smaller Elements)**
   - Traverse array from **left to right**
   - Maintain stack of **indices**
   - While stack not empty **and** current > input[stack.top] →  
     → `ans[stack.top] = current`, then pop
   - Push current index
   - Any remaining indices in stack → `-1`
---

2. **Next Smaller Element (NSE)**
   - Traverse array from right to left
   - Maintain **monotonic increasing stack**
   - While stack top ≥ current element → pop
   - If stack not empty → top is the next smaller
   - Else → answer is `-1`

---

3. **Previous Greater Element (PGE)**
   - Traverse array from left to right
   - Maintain **monotonic decreasing stack**
   - While stack top ≤ current element → pop
   - If stack not empty → top is the previous greater
   - Else → answer is `-1`

---

4. **Previous Smaller Element (PSE)**
   - Traverse array from left to right
   - Maintain **monotonic increasing stack**
   - While stack top ≥ current element → pop
   - If stack not empty → top is the previous smaller
   - Else → answer is `-1`
---

5. **Circular Next Greater Element (Circular NGE)**

   - 🔹 **Right to Left Approach (2n Traversal)**
     - Traverse array **from 2n-1 down to 0** (simulate circular)
     - Index wrap: `i % n`
     - Maintain **monotonic decreasing stack**
     - While stack top ≤ current → pop
     - If stack not empty → answer = stack top
     - Else → answer = `-1`
     - Complexity: O(n), since each element pushed/popped once


   - 🔹 **Left to Right Approach (Streaming Indices)**
     - Traverse array **0 to 2n-1**
     - Index wrap: `i % n`
     - While stack not empty **and** current > input[stack.top] →  
     → `ans[stack.top] = current`, then pop
     - Push current index if i < n (only during first pass)
     - Remaining indices in stack → `-1`

---

</details>
</details>