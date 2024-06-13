package com.grace.ywn.wavemoneyassignment

import org.junit.Test
import com.grace.ywn.wavemoneyassignment.utils.PathFinding
import org.junit.Assert.assertEquals

/**
 * Test class for the PathFinding utility functions.
 * Contains various test cases to ensure the correctness of the BFS shortest path algorithm.
 */
class PathFindingTest {

    /**
     * Tests a small grid with a clear path from the top-left to the bottom-right corner.
     * Expected shortest path length is 9.
     */
    @Test
    fun testSmallGrid() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0, 0), // First row with a starting point and obstacles
            intArrayOf(1, 1, 1, 1, 1), // Second row with a clear path
            intArrayOf(0, 0, 0, 0, 1), // Third row with obstacles and a path at the end
            intArrayOf(1, 1, 1, 1, 1), // Fourth row with a clear path
            intArrayOf(1, 1, 1, 1, 1)  // Fifth row with a clear path to the end
        )
        // Assert that the BFS algorithm finds the shortest path length of 9
        assertEquals(9, PathFinding.bfsShortestPath(grid))
    }

    /**
     * Tests a large grid (1000x1000) with no obstacles.
     * Expected shortest path length is 1999.
     */
    @Test
    fun testLargeGrid() {
        // Create a 1000x1000 grid filled with 1s (no obstacles)
        val grid = Array(1000) { IntArray(1000) { 1 } }
        // Assert that the BFS algorithm finds the shortest path length of 1999
        assertEquals(1999, PathFinding.bfsShortestPath(grid))
    }

    /**
     * Tests a grid where no path exists from the top-left to the bottom-right corner.
     * Expected result is -1 (indicating no path).
     */
    @Test
    fun testNoPathGrid() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0), // First row with a starting point and obstacles
            intArrayOf(0, 0, 0), // Second row completely blocked
            intArrayOf(0, 0, 1)  // Third row with an end point but no path
        )
        // Assert that the BFS algorithm returns -1 indicating no path found
        assertEquals(-1, PathFinding.bfsShortestPath(grid))
    }

    /**
     * Tests a grid with multiple possible paths.
     * The algorithm should find the shortest path, which is expected to be of length 5.
     */
    @Test
    fun testMultiplePathsGrid() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1), // First row with a clear path
            intArrayOf(1, 0, 1), // Second row with an obstacle in the middle
            intArrayOf(1, 1, 1)  // Third row with a clear path
        )
        // Assert that the BFS algorithm finds the shortest path length of 5
        assertEquals(5, PathFinding.bfsShortestPath(grid))
    }
}