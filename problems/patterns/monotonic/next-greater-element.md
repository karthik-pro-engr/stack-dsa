# 17-sep-2025 : Next Greater Element

## Problem statement

Given a string s, remove all adjacent duplicates repeatedly until no duplicates remain.

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
Think of stack like a pocket where you keep “future candidates” that might answer someone’s question.

👉 Rule:
When I look at a number, I ask:

- “Who is standing on my right that can help me?”

- If the stack top is **smaller or equal**, he’s useless → throw him out of pocket.

- If the stack top is **bigger**, then **he is my answer**.

After checking, I put myself into the stack, because I might be useful for someone on my left.


### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 