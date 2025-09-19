# 17-sep-2025 : Previous Greater Element

## Problem statement

Given an array `input`, for each element find the **nearest greater element on the left**.  
If there is no greater element on the left, return `-1`.

### Example

Input:  [2, 1, 5, 3, 3, 3, 6]
Output: [-1, 2, -1, 5, 5, 5, -1]

Explanation:
 What is the first number to the left that is bigger than current?
- For 2 → there is no previous left element -> -1.
- For 1 → the previous bigger is 2.
- For 5 → there is no previous bigger element -> -1.
- For 3 → the previous bigger is 5.
- For 3 → the previous bigger is 5.
- For 3 → the previous bigger is 5.
- For 6 → there is no bigger → -1.


So answer is:

    [-1, 2, -1, 5, 5, 5, -1]

### Constraints:

- 1 ≤ nums.length ≤ 10^5
- -10^9 ≤ nums[i] ≤ 10^9


## Notes / Hints
### Left To Right
Think of the stack like a memory of past candidates — only the strongest survivors from the left are kept, since weaker ones can’t help anyone anymore

#### 👉 Rule:
When I look at a number, I ask:

- “Who is standing on my left that can help me?”

- If the stack top is **smaller or equal**, he’s useless → throw him out of pocket.

- If the stack top is **bigger**, then **he is my answer**.

After checking, I put myself into the stack, because I might be useful for someone on my right.

### Right To Left
 #### 👉 Rule:
When I look at a number, I ask:

- “Who is standing on my right that can help me?”

- If the current element is **greater** than the number on top of the stack, it means the top of the stack has found its previous greater element — so I update the output at that index with the current value and remove it from the stack, because it won’t help anyone else.

After checking, I put myself into the stack, because I might be useful for someone on my left (who will come later in the right-to-left scan).


### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 