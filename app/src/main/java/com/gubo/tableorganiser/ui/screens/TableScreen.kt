package com.gubo.tableorganiser.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.gubo.tableorganiser.model.Person
import com.gubo.tableorganiser.ui.components.Table
import io.objectbox.Box
import kotlinx.coroutines.flow.MutableStateFlow

@Composable fun TableScreen(
    navController: NavHostController,
    box: Box<Person>,
) {
    Scaffold (modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) { paddingValues ->
        Box(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
        ) {
            // import JSON page (icon only in the corner)
            IconButton(
                onClick = { navController.navigate("importJson") },
                modifier = Modifier.align(Alignment.TopEnd).padding(bottom = 24.dp, end = 12.dp, top = 12.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Import JSON",
                )
            }
            
            // selector (dropdown)
            var expanded by remember { mutableStateOf(false) }
            var selectedPerson by remember { mutableStateOf<Person?>(null) }
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Button(onClick = { expanded = true }) {
                    Text("Choose Person")
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    box.all.forEach { person ->
                        DropdownMenuItem(
                            onClick = {
                                selectedPerson = person
                                expanded = false
                            },
                            text = { Text(person.name) },
                        )
                    }
                }
            }
            
            // table
            if (selectedPerson != null) {
                Table(selectedPerson!!)
            }
        }
    }
}