# LeetCode Problems

A personal collection of LeetCode solutions written in Java. Each problem is solved with an emphasis on understanding the underlying algorithm and data structures, not just getting a passing result. Solutions are organized by data type, and every method is commented to explain the reasoning behind the approach.

---

## Structure

- `ArrayExercises.java` — Problems operating on arrays
- `ListExercises.java` — Problems operating on linked lists
- `StringExercises.java` — Problems focused on string manipulation and sequence matching
- `IntExercises.java` — Problems focused on mathematical operations, bounds, and digit logic

---

## Solutions

### Arrays

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/description/) | HashMap — store complement at each step | $O(n)$ | $O(n)$ |
| 4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/description/) | Binary search on partition | $O(\log(n+m))$ | $O(1)$ |
| 11 | [Container With Most Water](https://leetcode.com/problems/container-with-most-water/) | Two-Pointer convergence tracking maximum area from outward boundaries inward | $O(n)$ | $O(1)$ |

### Lists

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Iterative traversal with carry | $O(n+m)$ | $O(n+m)$ |

### Strings

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/) | Sliding Window with HashMap tracking character indices | $O(n)$ | $O(\min(m, n))$ |
| 5 | [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/description/) | Expand Around Center (Iterating through odd and even centers) | $O(n^2)$ | $O(1)$ auxiliary |
| 6 | [Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/) | Matrix Simulation (Simulating row indexing direction) | $O(\text{numRows} \times n)$ | $O(\text{numRows} \times n)$ |
| 14 | [Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/) | Vertical scanning (Comparing character columns across all strings simultaneously) | $O(S)$ | $O(1)$ auxiliary |

### Integers & Math

| # | Problem | Approach | Time | Space |
|---|---------|----------|------|-------|
| 7 | [Reverse Integer](https://leetcode.com/problems/reverse-integer/description/) | Digit extraction via modulo with magnitude check and overflow guard | $O(\log_{10}(x))$ | $O(\log_{10}(x))$ |
| 8 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/) | Linear scan with state validation (whitespace, signs, digits, and overflow truncation) | $O(n)$ | $O(1)$ |
| 9 | [Palindrome Number](https://leetcode.com/problems/palindrome-number/) | String translation with Two-Pointer convergence check | $O(\log_{10}(x))$ | $O(\log_{10}(x))$ |
| 12 | [Integer to Roman](https://leetcode.com/problems/integer-to-roman/) | Base-10 positional decomposition with argument-grouped switch expressions | $O(1)$ | $O(1)$ |
| 13 | [Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | Value mapping pass with right-neighbor lookahead comparison to evaluate subtractive logic | $O(n)$ | $O(n)$ |

---

*Updated as new problems are solved.*