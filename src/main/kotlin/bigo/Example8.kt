package bigo

/**
 * EXAMPLE 8
 *
 * Suppose we had an algorithm that took in an array of strings, sorted each string, and then sorted the full array.
 * What would the runtime be?
 *
 * Let's define the variables:
 * - Let s be the length of the longest string
 * - Let a be the length of the array
 *
 * 1. Sorting each string is O(s log s)
 * 2. We do ☝ for every string: O(a * s log s)
 * 3. Now sort all the strings. Take into account that we need to compare the strings O(s) and there are O(a log a)
 *   comparisons, so O(s * a log a)
 * 4. Finally, add point 2 and 3. O(a * s log s) + O(s * a log a) = O(a * s (log a + log s)) ️
 *
 */
