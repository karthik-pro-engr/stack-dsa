# 21-sep-2025 : 📘 Problem: 739. Daily Temperatures

[LeetCode Problem Link](https://leetcode.com/problems/daily-temperatures/description/)


## Problem Statement

Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i`-th day to get a warmer temperature.

If there is no future day for which this is possible, set `answer[i] = 0`.

---

## Example

```text
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]

Explanation:
Day 0 → wait 1 day (74)
Day 1 → wait 1 day (75)
Day 2 → wait 4 days (76)
Day 3 → wait 2 days (72)
Day 4 → wait 1 day (72)
Day 5 → wait 1 day (76)
Day 6 → no warmer day → 0
Day 7 → no warmer day → 0
```
## Constraints

- 1 ≤ `temperatures.length` ≤ 10⁵
- 30 ≤ `temperatures[i]` ≤ 100


## Hints / Mental Model

### Right To Left Approach

Think of the **stack as a pocket of indices** representing future days with **warmer temperatures**.

#### Rule of the Pocket

1. Start from the **last day** and move backwards.  


2. While the stack is not empty and the temperature at the top index is **less than or equal to current day’s temperature**, pop it (useless).   


3. If the stack is not empty, the top index tells us how many days to wait:
   ```text
   answer[i] = stack.top - i
   ```   

4. Push the current index into the stack.


### Left To Right Approach

Think of the **stack as a waiting line of indices** where each index is waiting for warmer temperature to arrive.

#### Rule of the Waiting Line

When a temperature arrives, ask yourself:

1. Traverse the array from **left to right**.


2. While the stack is not empty and the **current temperature** is **greater than the temperature at the top index**, it means the current day is the "warmer future day" for that index:
   ```text
   answer[stack.top] = currentIndex - stack.top
   ```
   Pop the index from the stack.

3. After handling the above, push the **current index** into the stack (still waiting for its warmer day).
    

4. At the end, any indices left in the stack will have 0 in the answer array (no warmer days ahead).



### Time Complexity
- Each day’s index is pushed and popped at most once → **O(n)**
- Output construction → **O(n)**
- Total → O(n)

### Space Complexity
- Stack of indices → **O(n)**
- Output array → O(n)


## Solutions

- [739 - Daily Temperatures](../../../../src/main/kotlin/monotonic/leetcode/_739_DailyTemperatures.kt)