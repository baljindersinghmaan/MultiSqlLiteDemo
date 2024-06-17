package org.sqllitedemo.project.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.compose.AppTheme
import org.koin.androidx.compose.koinViewModel
import org.sqllitedemo.project.RocketLaunchViewModel

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun App() {
    val viewModel = koinViewModel<RocketLaunchViewModel>()
    val state by remember { viewModel.state }
    val pullToRefreshState = rememberPullToRefreshState()
    if (pullToRefreshState.isRefreshing) {
        viewModel.loadLaunches()
        pullToRefreshState.endRefresh()
    }
    AppTheme {
        Scaffold(topBar = {
            TopAppBar(title = {
                Text(
                    text = "SpaceX Launches",
                    style = MaterialTheme.typography.headlineLarge
                )
            })
        }) { padding ->

            Box(modifier = ) {

            }

        }
    }
}