package com.example.whiteboard.ui.whiteboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whiteboard.domain.model.DrawingTool
import com.example.whiteboard.ui.whiteboard.component.DrawingToolFAB
import com.example.whiteboard.ui.whiteboard.component.DrawingToolsCard
import com.example.whiteboard.ui.whiteboard.component.TopBar


@Composable
fun WhiteBoardScreen(
    modifier: Modifier = Modifier
) {
    var isDrawingToolCardVisible by rememberSaveable { mutableStateOf(false) }
    var selectedDrawingTool by remember { mutableStateOf(DrawingTool.PEN) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(20.dp),
            onHomeIconClick = { },
            onUndoIconClick = { },
            onRedoIconClick = { },
            onStrokeWidthClick = { },
            onDrawingColorClick = { },
            onBackgroundColorClick = { },
            onSettingClick = {}
        )
        DrawingToolFAB(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp),
            selectedTool = selectedDrawingTool, isVisible = !isDrawingToolCardVisible,
            onClick = { isDrawingToolCardVisible = true }
        )
        DrawingToolsCard(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp),
            isVisible = isDrawingToolCardVisible,
            selectedTool = selectedDrawingTool,
            onToolClick = { selectedDrawingTool = it },
            onCloseItemClick = {
                isDrawingToolCardVisible = false
            }
        )
    }
}