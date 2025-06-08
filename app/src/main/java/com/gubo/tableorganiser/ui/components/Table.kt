package com.gubo.tableorganiser.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gubo.tableorganiser.model.Person
import com.gubo.tableorganiser.ui.helper.ShapeModifier

@Composable fun Table(
    person: Person
) {
    Row(
        modifier = Modifier.background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Column {
            person.pros.forEachIndexed { i, pro ->
                when (i) {
                    0 -> Container(pro, ShapeModifier(12, 0, 0, 0))
                    person.pros.lastIndex -> Container(pro, ShapeModifier(0, 0, 12, 0))
                    else -> Container(pro)
                }
            }
        }
        
        Column {
            person.cons.forEachIndexed { i, con ->
                when (i) {
                    0 -> Container(con, ShapeModifier(0, 12, 0, 0))
                    person.cons.lastIndex -> Container(con, ShapeModifier(0, 0, 0, 12))
                    else -> Container(con)
                }
            }
        }
    }
}