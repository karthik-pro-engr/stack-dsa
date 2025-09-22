# 22-sep-2025 : 📘 Problem: 503. Next Greater Element II

[LeetCode Problem Link](https://leetcode.com/problems/next-greater-element-ii/)

## Problem Statement

Given a circular integer array `nums` (i.e., the next element of `nums[nums.length - 1]` is `nums[0]`), return the next greater number for every element in `nums`.

The next greater number of a number `x` is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return `-1` for this number.

## Example 1

**Input:** `nums = [1,2,1]`  
**Output:** `[2,-1,2]`  
**Explanation:** The first `1`'s next greater number is `2`;  
The number `2` can't find next greater number.  
The second `1`'s next greater number needs to search circularly, which is also `2`.

## Example 2

**Input:** `nums = [1,2,3,4,3]`  
**Output:** `[2,3,4,-1,4]`

## Constraints

- `1 <= nums.length <= 10^4`
- `-10^9 <= nums[i] <= 10^9`


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

- [Circular NGE](../../../../src/main/kotlin/monotonic/leetcode/_503_Next_Greater_Element_II.kt)