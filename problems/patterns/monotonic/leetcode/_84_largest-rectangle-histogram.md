# 24-sep-2025 : 📘 Problem: 84. Largest Rectangle in Histogram

[LeetCode Problem Link](https://leetcode.com/problems/largest-rectangle-in-histogram/)

## Problem Statement

Given an array of integers `heights` representing the histogram's bar height where the width of each bar is 1,  
return *the area of the largest rectangle* in the histogram.

## Example 1

**Input:** `heights = [2,1,5,6,2,3]`  
**Output:** `10`  
**Explanation:** The largest rectangle is formed by heights `[5,6]` with width 2 → area = 10.

## Example 2

**Input:** `heights = [2,4]`  
**Output:** `4`  
**Explanation:** The largest rectangle is height `2` or `4` itself.

## Constraints

- `1 <= heights.length <= 10^5`
- `0 <= heights[i] <= 10^4`

---

## Notes / Hints

We want to find, for each bar:
- The **Next Smaller Element (NSE)** on the right [NSE](../drills/next-smaller-element.md)
- The **Previous Smaller Element (PSE)** on the left [PSE](../drills/previous-smaller-element.md)

### Why do we need to find NSE and PSE?

- Imagine each input number as the **height of a vertical pillar**.
- The **ground is the base** and the **top of the pillar is a plank**.
- To form the largest rectangle at a given pillar, we must extend left and right as long as the neighboring pillars are **tall enough to support the plank**.
- The first shorter pillar on the **left** acts as a boundary → this is the **Previous Smaller Element (PSE)**.
- The first shorter pillar on the **right** acts as a boundary → this is the **Next Smaller Element (NSE)**.
- The current pillar’s **height** decides how tall the rectangle can be.
- The **width** is determined by how far left and right you can extend until blocked by a shorter pillar.
- Rectangle = **height × width**.
- Every pillar gives a possible rectangle, and the **maximum area among them** is the answer.

Then width = `nse[i] - pse[i] - 1`, area = `heights[i] * width`.

### Monotonic Stack Approach

👉 Rule:
- Traverse bars to find **PSE** (using increasing stack).
- Traverse bars to find **NSE**.
- Compute width for each index with `nse - pse - 1`.
- Take maximum area.

---

### Implementation Details

- **Sentinel values**:
  - For **PSE**: if none, use `-1`
    - 📝 Acts like a **virtual pillar before index 0** (left boundary).
    - Ensures formula `right - left - 1` includes bars starting from index `0`.

  - For **NSE**: if none, use `n` (size of array)
    - 📝 Acts like a **virtual pillar after index n-1** (right boundary).
    - Ensures formula counts bars all the way to the last index.

- ✅ Together, they guarantee **valid width calculation at edges** without special if-else handling.  
calculation for edges.

### Dry Run
```
PSE = [-1, -1, 1, 2, 1, 4]
```
Example:

- At heights[2]=5, PSE = index 1 (value 1).

- At heights[1]=1, no smaller on left → -1.
```
NSE = [1, 6, 4, 4, 6, 6]
```
Example:

- At heights[2]=5, NSE = index 4 (value 2).

- At heights[1]=1, NSE = index 6 (sentinel boundary).

```
width[i] = NSE[i] - PSE[i] - 1
area[i] = heights[i] * width[i]
```

```
i=0: h=2, width=1-(-1)-1=1, area=2
i=1: h=1, width=6-(-1)-1=6, area=6
i=2: h=5, width=4-1-1=2, area=10
i=3: h=6, width=4-2-1=1, area=6
i=4: h=2, width=6-1-1=4, area=8
i=5: h=3, width=6-4-1=1, area=3

```
---

### Time Complexity
- Each bar is pushed and popped at most once → **O(n)**

### Space Complexity
- Stack + arrays for NSE/PSE → **O(n)**

---

## Solutions

- [Largest Rectangle in Histogram](../../../../src/main/kotlin/monotonic/leetcode/_84_LargestRectangleHistogram.kt)
