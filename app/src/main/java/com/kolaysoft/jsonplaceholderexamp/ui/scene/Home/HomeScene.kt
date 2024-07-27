package com.kolaysoft.jsonplaceholderexamp.ui.scene.Home

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.kolaysoft.jsonplaceholderexamp.ui.component.PlaceholderTopAppBar
import com.kolaysoft.jsonplaceholderexamp.ui.scene.Home.widgets.HomeSceneCard

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScene() {
    val viewModel: HomeViewModel = hiltViewModel()
    val users by viewModel.data.collectAsState()

    Scaffold(
        topBar = {
            PlaceholderTopAppBar(title = "JsonPlaceHolder Example")
        },
        content = { innerPadding ->
            LazyColumn(contentPadding = innerPadding) {
                items(users) { user ->
                    HomeSceneCard(user = user)
                }
            }
        }
    )

}

@Preview
@Composable
fun HomeScenePreview() {
    HomeScene()
}