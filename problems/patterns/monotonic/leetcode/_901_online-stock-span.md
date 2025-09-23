# 23-sep-2025 : 📘 Problem: 901. Online Stock Span

[LeetCode Problem Link](https://leetcode.com/problems/online-stock-span/description/)

## Problem Statement

Design an algorithm that collects daily stock prices and returns the **span** of that stock's price for the current day.

The **span** of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the stock price was **less than or equal to today's price**.

Implement the `StockSpanner` class:

- `StockSpanner()` Initializes the object of the class.
- `int next(int price)` Returns the span of the stock's price given that today's price is `price`.

---

## Example

```text
Input:
["StockSpanner","next","next","next","next","next","next","next"]
[[],[100],[80],[60],[70],[60],[75],[85]]

Output:
[null,1,1,1,2,1,4,6]

Explanation:
StockSpanner stockSpanner = new StockSpanner();
stockSpanner.next(100); // return 1
stockSpanner.next(80);  // return 1
stockSpanner.next(60);  // return 1
stockSpanner.next(70);  // return 2
stockSpanner.next(60);  // return 1
stockSpanner.next(75);  // return 4
stockSpanner.next(85);  // return 6
```

## Constraints

- 1 ≤ `price` ≤ 10⁵
- At most 10⁴ calls will be made to `next`.

## Hints / Mental Model

### The Span Accumulation Trick 🪜

Instead of walking backwards one day at a time, **jump in chunks** using a stack.

- Maintain a **monotonic decreasing stack** with pairs: `(price, spanSoFar)`
- For each new price:
    1. Start `span = 1`
    2. While stack top’s price ≤ current price:
        - Pop it and **accumulate its span**
        - `span += prevSpan`
    3. Push `(price, span)` into the stack
    4. Return `span`


### Story Analogy (School Student Level)

Imagine boys standing in a line with different heights (prices).  
A new boy joins at the end and asks:  
**“How many boys behind me are shorter or equal?”**

- Naively, he checks one by one (slow).
- With the stack trick, each shorter boy says:
  > “Hey, I already counted X boys behind me.  
  > Skip all of us in one jump!”

This **cheat sheet** lets you skip fast → O(n) total.


### Dry Run Example

Prices = `[100, 80, 60, 70, 60, 75, 85]`

| Day | Price | Action (pops)         | Span | Stack State                    |
|-----|-------|-----------------------|------|--------------------------------|
| 1   | 100   | —                     | 1    | [(100,1)]                      |
| 2   | 80    | stop (100 > 80)       | 1    | [(100,1),(80,1)]               |
| 3   | 60    | stop (80 > 60)        | 1    | [(100,1),(80,1),(60,1)]        |
| 4   | 70    | pop (60,1) → span=2   | 2    | [(100,1),(80,1),(70,2)]        |
| 5   | 60    | stop (70 > 60)        | 1    | [(100,1),(80,1),(70,2),(60,1)] |
| 6   | 75    | pop (60,1),(70,2) → 4 | 4    | [(100,1),(80,1),(75,4)]        |
| 7   | 85    | pop (75,4),(80,1) → 6 | 6    | [(100,1),(85,6)]               |

Answer = `[1,1,1,2,1,4,6]`


### Time Complexity
- Each price pushed/popped at most once → **O(n)** amortized
- Each `next()` runs in **O(1)** average time


### Space Complexity
- Stack stores at most all prices → **O(n)**

## Solutions

- [901- OnlineStockSpan](../../../../src/main/kotlin/monotonic/leetcode/_901_OnlineStockSpan.kt)


