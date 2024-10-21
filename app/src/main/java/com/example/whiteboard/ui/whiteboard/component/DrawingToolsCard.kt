package com.example.whiteboard.ui.whiteboard.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whiteboard.domain.model.DrawingTool


@Composable
fun DrawingToolsCard(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    selectedTool: DrawingTool,
    onToolClick: (DrawingTool) -> Unit,
    onCloseItemClick: () -> Unit
) {

    AnimatedVisibility(
        modifier = Modifier,
        visible = isVisible,
        enter = slideInVertically(tween(durationMillis = 500)) { h -> h },
        exit = slideOutVertically(tween(durationMillis = 500)) { h -> h },
    ) {
        ElevatedCard {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LazyRow(
                    modifier = modifier.weight(1f),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(DrawingTool.entries) { drawingTool ->
                        DrawingToolItem(
                            drawingTool = drawingTool,
                            isSelected = selectedTool == drawingTool,
                            onToolClick = { onToolClick(drawingTool) },
                        )
                    }
                }
                FilledIconButton(onClick = { onCloseItemClick() }) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier.size(25.dp),
                    )
                }
            }
        }
    }

}

@Composable
private fun DrawingToolItem(
    modifier: Modifier = Modifier,
    drawingTool: DrawingTool,
    isSelected: Boolean,
    onToolClick: () -> Unit
) {
    val imageIcon =
        listOf(DrawingTool.PEN, DrawingTool.HIGHLIGHTER, DrawingTool.LASER, DrawingTool.ERASER)
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = { onToolClick() }) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = drawingTool.resId),
                contentDescription = drawingTool.name,
                tint = if (imageIcon.contains(drawingTool)) {
                    Color.Unspecified
                } else {
                    LocalContentColor.current
                }
            )
        }
        if (isSelected) {
            Box(
                modifier = Modifier
                    .background(LocalContentColor.current)
                    .size(25.dp, 1.dp)
            )
        }
    }
}

@Preview
@Composable
private fun DrawingToolsCardPreview() {
    DrawingToolsCard(
        isVisible = true,
        selectedTool = DrawingTool.PEN,
        onToolClick = {},
        onCloseItemClick = {}
    )
}