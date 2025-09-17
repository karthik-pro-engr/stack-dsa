# 17-sep-2025 : Previous Smaller Element

## Problem statement

Given an array `input`, for each element find the **nearest smaller element on the left**.  
If there is no smaller element on the left, return `-1`.

### Example

Input:  [2, 1, 5, 3, 3, 3, 6]
Output: [-1, -1, 1, 1, 1, 1, 3]

Explanation:
 What is the first number to the left that is smaller than current?
- For 2 → there is no previous left element -> -1.
- For 1 → there is no previous smaller -> -1.
- For 5 → the previous smaller element -> 1.
- For 3 → the previous smaller element -> 1.
- For 3 → the previous smaller element -> 1.
- For 3 → the previous smaller element -> 1.
- For 6 → the previous smaller element -> 3.


So answer is:

    [-1, -1, 1, 1, 1, 1, 3]

### Constraints:

- 1 ≤ nums.length ≤ 10^5
- -10^9 ≤ nums[i] ≤ 10^9


## Notes / Hints
Think of the stack like a memory of past candidates — only the weakest survivors from the left are kept, since stronger ones can’t help anyone anymore

👉 Rule:
When I look at a number, I ask:

- “Who is standing on my left that can help me?”

- If the stack top is **greater or equal**, he’s useless → throw him out of pocket.

- If the stack top is **smaller**, then **he is my answer**.

After checking, I put myself into the stack, because I might be useful for someone on my right.


### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 