package com.example.whiteboard.ui.whiteboard.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.whiteboard.domain.model.DrawingTool

@Composable
fun DrawingToolFAB(
    modifier: Modifier = Modifier,
    selectedTool: DrawingTool,
    isVisible : Boolean,
    onClick: () -> Unit
) {
    val imageIcon =
        listOf(DrawingTool.PEN, DrawingTool.HIGHLIGHTER, DrawingTool.LASER, DrawingTool.ERASER)
    AnimatedVisibility(
        modifier = Modifier, visible = isVisible
    ) {
        FloatingActionButton(onClick = { onClick() }) {
            Icon(
                modifier = Modifier.size(25.dp),
                painter = painterResource(id = selectedTool.resId),
                contentDescription = selectedTool.name,
                tint = if (imageIcon.contains(selectedTool)) {
                    Color.Unspecified
                } else {
                    LocalContentColor.current
                }
            )
        }
    }
}