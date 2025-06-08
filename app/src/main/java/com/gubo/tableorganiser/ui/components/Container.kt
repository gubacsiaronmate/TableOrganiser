package com.gubo.tableorganiser.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gubo.tableorganiser.ui.helper.ShapeModifier

@Composable fun Container(
    data: String,
    corner: ShapeModifier = ShapeModifier(0, 0, 0, 0),
) {
    Column(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.White,
                shape = RoundedCornerShape(
                    topStartPercent = corner.topLeft,
                    topEndPercent = corner.topRight,
                    bottomEndPercent = corner.bottomLeft,
                    bottomStartPercent = corner.bottomRight
                )
            ),
    ) { Text(
        text = data,
        color = Color.White,
        style = MaterialTheme.typography.bodyMedium
    ) }
}