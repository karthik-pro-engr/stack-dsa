# 17-sep-2025 : Next Greater Element

## Problem statement

Given an array `input`, for each element find the **nearest greater element on the right**.  
If there is no greater element on the right, return `-1`.

### Example

Input:  [2, 1, 5, 3, 6]
Output: [5, 5, 6, 6, -1]

Explanation:
 What is the first number to the right that is bigger than me?
- For 2 → the next bigger is 5 (because after 2, we see 1 then 5).
- For 1 → the next bigger is 5.
- For 5 → the next bigger is 6.
- For 3 → the next bigger is 6.
- For 6 → there is no bigger → -1.


So answer is:

    [5, 5, 6, 6, -1]

### Constraints:

- 1 ≤ nums.length ≤ 10^5
- -10^9 ≤ nums[i] ≤ 10^9


## Notes / Hints

### Right To Left Approach

Think of stack like a pocket where you keep “future candidates” that might answer someone’s question.

👉 Rule:
When I look at a number, I ask:

- “Who is standing on my right that can help me?”

- If the stack top is **smaller or equal**, he’s useless → throw him out of pocket.

- If the stack top is **bigger**, then **he is my answer**.
Yeah
After checking, I put myself into the stack, because I might be useful for someone that comes before me (to my left).

### Left To Right Approach

Rule: 
When  I look at a number, I ask:

- Look at each number as it comes in from left to right.

- Keep a stack of elements waiting for their next greater number.

- When a new number arrives:

    - While the stack top is smaller than the current number, it has found its next greater → resolve it and remove from stack.
  
    - If the stack top is greater or equal, leave it in the stack (it’s still waiting).

- After handling the current number, push it onto the stack — it might be the next greater for numbers coming after it.

- At the end, any numbers left in the stack have no next greater element → -1.

### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 

## Solutions

- [Right To Left and Right To Left NGE](../../../../src/main/kotlin/monotonic/drills/NextGreaterElement.kt)