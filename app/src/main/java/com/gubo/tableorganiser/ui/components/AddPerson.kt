package com.gubo.tableorganiser.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.gubo.tableorganiser.model.Person
import com.gubo.tableorganiser.ui.helper.ShapeModifier
import com.gubo.tableorganiser.ui.state.PersonFormState
import io.objectbox.Box

@Composable fun AddPerson(
    box: Box<Person>
) {
    val isAddProDialogOpen = remember { mutableStateOf(false) }
    val isAddConDialogOpen = remember { mutableStateOf(false) }
    val personState = rememberSaveable {
        PersonFormState(
            initialName = "",
            initialPros = emptyList(),
            initialCons = emptyList(),
        )
    }
    
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(8.dp),
        color = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                text = "Add new person",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
            
            OutlinedTextField(
                value = personState.name,
                onValueChange = { personState.updateName(it) },
                label = { Text("Name") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f),
                ) {
                    Text(
                        text = "Pros",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    
                    if (personState.pros.isNotEmpty()) {
                        personState.pros.forEach { pro ->
                            Container(
                                data = pro,
                                corner = ShapeModifier.ROUNDED,
                            )
                        }
                    }
                    
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { isAddProDialogOpen.value = true }
                    ) { Text("Add pro") }
                }
                
                Column(
                    modifier = Modifier.fillMaxWidth(0.5f),
                ) {
                    Text(
                        text = "Cons",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                    )
                    
                    if(personState.cons.isNotEmpty()) {
                        personState.cons.forEach { con ->
                            Container(
                                data = con,
                                corner = ShapeModifier.ROUNDED,
                            )
                        }
                    }
                    
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { isAddConDialogOpen.value = true }
                    ) { Text("Add con") }
                }
            }
        }
    }
}