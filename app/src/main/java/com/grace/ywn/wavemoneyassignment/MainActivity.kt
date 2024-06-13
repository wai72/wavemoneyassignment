package com.grace.ywn.wavemoneyassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grace.ywn.wavemoneyassignment.ui.theme.WaveMoneyAssignmentTheme
import com.grace.ywn.wavemoneyassignment.utils.PathFinding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to the PathFindingScreen composable wrapped in the app theme
        setContent {
            WaveMoneyAssignmentTheme {
                // A surface container using the background color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PathFindingScreen()
                }
            }
        }
    }
}

@Composable
fun PathFindingScreen() {
    // Mutable state to hold the result of the pathfinding operation
    var result by remember { mutableStateOf("Result will be shown here") }

    // Sample grid for the pathfinding task (you can change the grid as you like)
    val grid = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 0, 1),
        intArrayOf(1, 1, 1)
    )

    // Main layout column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header text
        Text(
            text = "Path Finding in Grid",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Display the grid
        GridDisplay(grid)

        Spacer(modifier = Modifier.height(20.dp))

        // Button to trigger the pathfinding algorithm
        Button(onClick = {
            val pathLength = PathFinding.bfsShortestPath(grid)
            // Update the result based on the pathfinding outcome
            result = if (pathLength != -1) {
                "Shortest Path Length: $pathLength"
            } else {
                "No path found"
            }
        }) {
            Text("Find Path")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display the result of the pathfinding
        Text(result)
    }
}

@Composable
fun GridDisplay(grid: Array<IntArray>) {
    // LazyColumn to display each row of the grid
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        // Iterate over each row in the grid
        items(grid.size) { rowIndex ->
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                // Iterate over each cell in the row
                items(grid[rowIndex].size) { colIndex ->
                    Cell(
                        value = grid[rowIndex][colIndex],
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Cell(value: Int, modifier: Modifier = Modifier) {
    // Box to represent a cell in the grid
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(4.dp)
            .background(if (value == 1) Color.Green else Color.Red) // Green for path, Red for obstacle
    ) {
        // Display the value of the cell (1 or 0)
        Text(
            text = value.toString(),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
    }
}
