# 17-sep-2025 : Next Smaller Element

## Problem statement

Given an array `input`, for each element find the **nearest smaller element on the right**.  
If there is no smaller element on the right, return `-1`.

### Example

Input:  [2, 1, 5, 3, 3, 3, 6]
Output: [1, -1, 3, -1, -1, -1, -1]

Explanation:
 What is the first number to the right that is smaller than me?
- For 2 → the next smaller is 1.
- For 1 → there is no smaller -> -1.
- For 5 → the next smaller is 3.
- For 3 → there is no smaller -> -1.
- For 3 → there is no smaller -> -1.
- For 3 → there is no smaller -> -1.
- For 6 → there is no smaller → -1.


So answer is:

    [1, -1, 3, -1, -1, -1, -1]

### Constraints:

- 1 ≤ nums.length ≤ 10^5
- -10^9 ≤ nums[i] ≤ 10^9


## Notes / Hints
Think of stack like a pocket where you keep “future candidates” that might answer someone’s question.

👉 Rule:
When I look at a number, I ask:

- “Who is standing on my right that can help me?”

- If the stack top is **greater or equal**, he’s useless → throw him out of pocket.

- If the stack top is **smaller**, then **he is my answer**.

After checking, I put myself into the stack, because I might be useful for someone that comes before me (to my left).


### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 