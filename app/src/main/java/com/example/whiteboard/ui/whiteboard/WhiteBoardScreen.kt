package com.example.whiteboard.ui.whiteboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.whiteboard.ui.whiteboard.component.TopBar


@Composable
fun WhiteBoardScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
    ) {
        TopBar(
            modifier = Modifier.align(Alignment.TopCenter).padding(20.dp),
            onHomeIconClick = { },
            onUndoIconClick = { },
            onRedoIconClick = { },
            onStrokeWidthClick = { },
            onDrawingColorClick = { },
            onBackgroundColorClick = { },
            onSettingClick = {}
        )
    }
}