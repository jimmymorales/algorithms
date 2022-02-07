package bigo

/**
 * EXAMPLE 7
 *
 * Which of the following are equivalent to O(N)? Why?
 *
 * - O(N+P), where P < N / 2
 *   This is equivalent to O(N). Since P < N/2, N is the dominant term and P can be considered a constant.
 *
 * - 0(2N)
 *   This is equivalent to O(N). Because we can drop constants.
 *
 * - O(N+log N)
 *   This is equivalent to O(N). O(N) dominates O(log N) so we can drop the latter.
 *
 * - O(N+M)
 *   This is NOT equivalent because we don't really if there is a relationship between N and M.
 */
