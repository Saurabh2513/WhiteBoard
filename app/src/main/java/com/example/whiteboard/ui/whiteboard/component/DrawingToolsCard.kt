package com.example.whiteboard.ui.whiteboard.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whiteboard.domain.model.DrawingTool

@Composable
fun DrawingToolsCard(modifier: Modifier = Modifier) {
    ElevatedCard {
        LazyRow {
            items(DrawingTool.entries) { drawingTool ->
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter =painterResource(id =drawingTool.resId ),
                        contentDescription = drawingTool.name)
                }
            }
        }
    }
}

@Preview
@Composable
private fun DrawingToolsCardPreview() {
    DrawingToolsCard()
}