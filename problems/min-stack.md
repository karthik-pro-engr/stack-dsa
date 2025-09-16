# 16-Sep-2025 : Min Stack

## Problem Statement

Design a stack that supports the following operations **efficiently**:

1. `push(x)` — Push element `x` onto the stack.
2. `pop()` — Remove the top element from the stack.
3. `top()` — Return the top element.
4. `getMin()` — Retrieve the minimum element in the stack.
5. `popMin()` — Remove the minimum element from the stack (optional advanced variant).

All operations should be **O(1)** if possible (or O(log n) for `popMin` if using an auxiliary structure).

---

## Example
MinStack stk = new MinStack();
stk.push(5);
stk.push(3);
stk.push(7);
stk.getMin(); // returns 3
stk.popMin(); // removes 3
stk.getMin(); // returns 5
stk.top(); // returns 7
stk.pop(); // removes 7



---

## Constraints

- 1 ≤ x ≤ 10^9
- 1 ≤ number of operations ≤ 10^5

---

## Notes / Hints

- Maintain an **auxiliary stack** (`minStack`) to track the current minimum at each level.
- For the `popMin` variant, consider using a **secondary data structure** (like a TreeMap or PriorityQueue) to remove the minimum efficiently.
- All other operations (`push`, `pop`, `top`, `getMin`) must remain O(1).

---

## Related Concepts

- Stack
- Auxiliary Stack
- Monotonic Tracking
