# Path Finding in a Grid Android App

## Overview
This Android app demonstrates an algorithm to find the shortest path from the top-left corner to the bottom-right corner of a 2D grid using BFS.

## Requirements
- Android Studio

## Build Instructions
1. Ensure you have Android Studio installed.
2. Open the project in Android Studio.
3. Go to `Build` > `Make Project`.

## Run Instructions
To run the application:
1. Connect an Android device or start an emulator.
2. Click `Run` > `Run 'app'`.

To run the unit tests:
1. Go to `Run` > `Run 'All Tests'`.

## Algorithm Explanation
The solution uses the Breadth-First Search (BFS) algorithm to find the shortest path in an unweighted grid. BFS is suitable as it explores all possible paths level by level, ensuring the shortest path is found.

## Edge Cases Handled
- Empty grid
- Obstacles at the start or end
- No possible path

## Assumptions
- The grid is well-formed (rectangular)
- Movement is restricted to up, down, left, and right

## Unit Tests
The project includes unit tests that cover:
- Small grids
- Large grids
- Grids with no possible path
- Grids with multiple possible paths

## Complexity
Time Complexity: O(nxm)
Space Complexity: O(nxm)
