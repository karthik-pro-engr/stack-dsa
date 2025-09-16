# Stack Tricks & Patterns

## Common Stack Patterns

1. **Reverse a String**
    - Push all characters onto a stack
    - Pop all characters to build the reversed string
    - Use `StringBuilder` or `CharArray` for efficiency


2. **Valid Parentheses**
   - Push opening brackets
   - Pop and match closing brackets
   - Stack empty at the end → valid


3. **Min Stack**
   - Maintain auxiliary stack to track minimum
   - Push/pop in sync with main stack