# 21-sep-2025 : 📘 Problem: 496. Next Greater Element I

[LeetCode Problem Link](https://leetcode.com/problems/next-greater-element-i/description/)


## Problem Statement

You are given two integer arrays `nums1` and `nums2`, where `nums1` is a subset of `nums2`.

Return an array of the same length as `nums1` such that each element `nums1[i]` is replaced by its **next greater element** in `nums2`. If no such element exists, replace it with `-1`.

The **next greater element** of a number `x` in `nums1` is the first greater number to its right in `nums2`.

---

## Example

```text
Input: nums1 = [4,1,2], nums2 = [1,3,4,2,5]
Output: [5,3,-1]
Explanation:
For num = 4, the next greater number is 5.
For num = 1, the next greater number is 3.
For num = 2, there is no next greater number, so we return -1.
```
## Constraints

- 1 ≤ `nums1.length` ≤ 1000
- 1 ≤ `nums2.length` ≤ 1000
- 0 ≤ `nums1[i], nums2[i]` ≤ 10⁴
- All integers in `nums1` and `nums2` are unique.
- All integers in `nums1` are present in `nums2`.


## Hints / Mental Model

### Right To Left Approach

Think of the **stack as a pocket** where you keep **future candidates** that might answer someone’s question.

#### Rule of the Pocket

When a number arrives, ask yourself:

1. **“Who on my right can help me?”**
    - Look at the top of the stack (your pocket).

2. **Evaluate the stack top:**
    - **Smaller or equal?** → useless, remove them from the pocket.
    - **Bigger?** → that’s your answer; store it in the map.

3. **After checking:**
    - Put yourself into the pocket (stack).
    - You might be the answer for someone to your left.

### Implementation Tip

- Use a **map** to record the next greater element for each number in `nums2`.
- Then, for `nums1`, simply build the output array from the map.


### Left To Right Approach

Think of the **stack as a waiting line** where numbers are standing, each looking for a **next greater number coming after them**.

#### Rule of the Waiting Line

When a number arrives, ask yourself:

1. **“Who before me is waiting for their next greater?”**
    - Look at the top of the stack (the waiting numbers).

2. **Evaluate the stack top:**
    - **Smaller than current?** → it has found its next greater → resolve it, store it in the map, and remove it from the stack.
    - **Greater or equal?** → leave it in the stack (still waiting).

3. **After handling the current number:**
    - Push yourself onto the stack — you might be the next greater for numbers coming later.

4. **At the end:**
    - Any numbers left in the stack have no next greater → map them to `-1`.

### Implementation Tip

- Use a **map** to record the next greater element for each number in `nums2`.
- Then, for `nums1`, build the output array by looking up each number in the map.


### Time Complexity
- Traversing `nums2` once, each element pushed/popped at most once → **O(n2)**
- Building output for `nums1` → **O(n1)**
- Total → **O(n1 + n2) ≈ O(n)**

### Space Complexity
- Stack for `nums2` → O(n2)
- Map for next greater elements → O(n2)
- Output array → O(n1)
- Total → **O(n1 + n2) ≈ O(n)**


## Solutions

- [_496_NGE_I](../../../../src/main/kotlin/monotonic/leetcode/_496_NextGreaterElementI.kt)