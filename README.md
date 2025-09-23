# Stack DSA Repository

This repository contains stack-based problems, solutions, and mental tricks for efficient problem-solving.

## Stack Tricks and Mental Patterns -[stack-tricks.md](cheatsheets/stack-tricks.md)
   

### Problems by Category

<details open> 
<summary><strong> Basics </strong></summary>

1. **Reverse String** - [reverse-string.md](problems/basics/reverse-string.md)  
   Reverse the characters of a string using a stack.

2. **Valid Parentheses** - [valid-parentheses.md](problems/basics/valid-parentheses.md)  
   Check if a string containing `()`, `{}`, `[]` is valid using a stack.

3. **Min Stack** - [min-stack.md](problems/basics/min-stack.md)  
   Design a stack that supports `push`, `pop`, `top`, `getMin`, and optionally `popMin` efficiently.

4. **Remove All Adjacent Duplicates** - [remove-all-adjacent-duplicates.md](problems/basics/remove-all-adjacent-duplicates.md)  
   Given a string, repeatedly remove pairs of adjacent duplicate characters until no more can be removed, using a stack.

</details>

---

<details open> 
<summary><strong> Patterns </strong></summary>
<details open>
<summary><strong> Monotonic </strong></summary>

1. **Next Greater Element** - [next-greater-element.md](problems/patterns/monotonic/drills/next-greater-element.md)  
   For each element in an array, find the next greater element to its right using a monotonic stack.

2. **Next Smaller Element** - [next-smaller-element.md](problems/patterns/monotonic/drills/next-smaller-element.md)  
   For each element in an array, find the next smaller element to its right using a monotonic stack.

3. **Previous Greater Element** - [previous-greater-element.md](problems/patterns/monotonic/drills/previous-greater-element.md)  
   For each element in an array, find the previous greater element to its left using a monotonic stack.

4. **Previous Smaller Element** - [previous-smaller-element.md](problems/patterns/monotonic/drills/previous-smaller-element.md)  
   For each element in an array, find the previous smaller element to its left using a monotonic stack.

5. **Circular Next Greater Element** - [circular-greater-element.md](problems/patterns/monotonic/drills/circular-next-greater-element.md)

</details>
</details>

---

<details open> 
<summary><strong> LeetCode </strong></summary>
<details open>
<summary><strong> Monotonic </strong></summary>

1. **496 - Next Greater Element - I** - [_496_next-greater-element-i.md](problems/patterns/monotonic/leetcode/_496_next-greater-element-i.md)  
   Given two arrays, find the next greater element for each number in the first array using a monotonic stack and map.   


2. **503 - Next Greater Element II** - [_503_next-greater-ii.md](problems/patterns/monotonic/leetcode/_503_next-greater-element-ii.md)   
   Given a circular integer array, return the next greater number for every element. The next greater number is the first greater element traversing circularly. If it doesn't exist, return -1.


3. **739- Daily Temperatures** - [_739_daily-temperatures.md](problems/patterns/monotonic/leetcode/_739_daily-temperatures.md)  
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.


4. **901 - Online Stock Span** - [_901_online-stock-span.md](problems/patterns/monotonic/leetcode/_901_online-stock-span.md)  
   Design a data structure that collects daily stock prices and returns the span of the stock's price for the current day, where the span is the maximum number of consecutive days starting from today and going backwards for which the stock price was less than or equal to today's price.

</details>
</details>

## 🛠️ How to Use

Clone the repo and explore each markdown file for problem statements, explanations, and code walkthroughs.

```bash
git clone https://github.com/your-username/stack-dsa-repo.git
   

