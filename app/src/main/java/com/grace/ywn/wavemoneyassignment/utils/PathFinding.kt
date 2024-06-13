package com.grace.ywn.wavemoneyassignment.utils

import java.util.LinkedList
import java.util.Queue

/**
 * Utility object for pathfinding algorithms.
 */
object PathFinding {

    /**
     * Directions array used for moving in the grid: right, down, left, up.
     * Each direction is represented as a pair of row and column offsets.
     */
    private val directions = arrayOf(
        intArrayOf(0, 1),   // Move right
        intArrayOf(1, 0),   // Move down
        intArrayOf(0, -1),  // Move left
        intArrayOf(-1, 0)   // Move up
    )

    /**
     * Function to find the shortest path in a binary grid using Breadth-First Search (BFS).
     * @param grid A 2D array representing the grid where 1 is a valid path and 0 is an obstacle.
     * @return The length of the shortest path from the top-left to the bottom-right corner, or -1 if no path exists.
     */
    fun bfsShortestPath(grid: Array<IntArray>): Int {
        // Check if the grid is empty or invalid
        if (grid.isEmpty() || grid[0].isEmpty()) return -1

        val rows = grid.size    // Number of rows in the grid
        val cols = grid[0].size // Number of columns in the grid

        // Initialize the queue for BFS. Each element is a Triple (row, col, path length)
        val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
        queue.add(Triple(0, 0, 1)) // Start from the top-left corner with path length 1

        // Check if the starting or ending points are blocked
        if (grid[0][0] == 0 || grid[rows - 1][cols - 1] == 0) {
            return -1
        }

        // Perform BFS to find the shortest path
        while (queue.isNotEmpty()) {
            val (row, col, length) = queue.poll() // Dequeue the front element

            // Check if we have reached the bottom-right corner
            if (row == rows - 1 && col == cols - 1) {
                return length
            }

            // Explore all four possible directions
            for (direction in directions) {
                val newRow = row + direction[0]
                val newCol = col + direction[1]

                // Check if the new position is within bounds and is a valid path (not visited)
                if (newRow in 0 until rows && newCol in 0 until cols && grid[newRow][newCol] == 1) {
                    queue.add(Triple(newRow, newCol, length + 1)) // Enqueue the new position with incremented path length
                    grid[newRow][newCol] = -1 // Mark the new position as visited
                }
            }
        }

        // Return -1 if no path is found
        return -1
    }
}
