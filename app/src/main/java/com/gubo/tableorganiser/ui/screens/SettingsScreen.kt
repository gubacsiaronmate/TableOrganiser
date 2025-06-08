package com.gubo.tableorganiser.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gubo.tableorganiser.model.Person
import io.objectbox.Box

@OptIn(ExperimentalMaterial3Api::class)
@Composable fun SettingsScreen(
    box: Box<Person>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant
                ),
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues).fillMaxSize()
        ) {
            var isAddPersonDialogOpen by remember { mutableStateOf(false) }
            Column(
                modifier = Modifier.fillMaxSize().align(Alignment.TopCenter),
            ) {
                Button(
                    onClick = { isAddPersonDialogOpen = true },
                ) { Text("Add new Person") }
            }
            
            
            if (isAddPersonDialogOpen) {
            
            }
        }
    }
}