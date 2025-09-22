# 19-sep-2025 : Circular Next Greater Element

## Problem statement

Given a **circular array** `input`, for each element find the **nearest greater element on the right**.  
If there is no greater element on the right(even after wrapping around), return `-1`.

### Example

Input:  [2, 1, 5, 6, 3]
Output: [5, 5, 6, -1, 5]

Explanation:
 What is the first number to the right that is bigger than me?
- For 2 → the next bigger is 5 (because after 2, we see 1 then 5).
- For 1 → the next bigger is 5.
- For 5 → the next bigger is 6.
- For 6 → there is no bigger → -1.
- For 3 → normal NGE would be -1, but since array is circular, wrapping gives next greater = 5.



So answer is:

    [5, 5, 6, -1, 5]

### Constraints:

- 1 ≤ nums.length ≤ 10^5
- -10^9 ≤ nums[i] ≤ 10^9


## Notes / Hints

We **simulate the array twice** (`2n` iterations) using module(`i % n`) to wrap around.

### Right to Left Approach

👉 Rule:
- Traverse array **from right to left**, but extend it to **2n iteration**
- At each step:
    - While stack top ≤ current → pop (useless).
    - If stack not empty → its top is the next greater.
    - Push current index.

This way, every element also gets to "see" elements on its left (due to wrapping).

### Left → Right Approach
- Traverse array **from left to right**, simulate it **twice** (`2n`).
- Maintain a stack of indices waiting for their next greater.
- For each new element:
    - While stack top < current → resolve it (current is its answer).
    - Push index during **first pass only**.
- At the end, unresolved indices → `-1`.

### Why Twice?
Because an element at the end (like `3` above) might find its answer only if we loop back to the beginning.


### Time Complexity
- Each element is pushed once and popped at most once → **O(n)**

### Space Complexity
- Stack + result array → **O(n)** 

## Solutions

- [Circular NGE](../../../../src/main/kotlin/monotonic/drills/CircularNextGreaterElement.kt)