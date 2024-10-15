package com.example.whiteboard.ui.whiteboard.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.whiteboard.R
import com.example.whiteboard.ui.theme.WhiteBoardTheme

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    onHomeIconClick: () -> Unit,
    onUndoIconClick: () -> Unit,
    onRedoIconClick: () -> Unit,
    onStrokeWidthClick: () -> Unit,
    onDrawingColorClick: () -> Unit,
    onBackgroundColorClick: () -> Unit,
    onSettingClick: () -> Unit,
) {

    var isMoreOptionMenu by rememberSaveable { mutableStateOf(false) }

    Row(modifier = Modifier) {

        FilledIconButton(onClick = { onHomeIconClick() }) {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = "Home",
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        FilledIconButton(onClick = { onUndoIconClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_undo),
                contentDescription = "Undo",
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        FilledIconButton(onClick = { onRedoIconClick() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_redo),
                contentDescription = "Redo",
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }
        Box {
            FilledIconButton(onClick = { isMoreOptionMenu = true }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert, contentDescription = "More Options",
                    modifier = Modifier.size(25.dp),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
            MoreOptionsMenu(
                isExpanded = isMoreOptionMenu,
                onMenuDismiss = { isMoreOptionMenu = false },
                onStrokeWidthClick = onStrokeWidthClick,
                onDrawingColorClick = onDrawingColorClick,
                onBackgroundColorClick = onBackgroundColorClick,
                onSettingClick = onSettingClick
            )
        }
    }
}

@Composable
private fun MoreOptionsMenu(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onMenuDismiss: () -> Unit,
    onStrokeWidthClick: () -> Unit,
    onDrawingColorClick: () -> Unit,
    onBackgroundColorClick: () -> Unit,
    onSettingClick: () -> Unit,
) {
    DropdownMenu(
        modifier = Modifier,
        expanded = isExpanded,
        onDismissRequest = { onMenuDismiss() }) {
        DropdownMenuItem(
            text = { Text(text = "Stroke Width") },
            onClick = {
                onStrokeWidthClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Stroke Width")
            }
        )
        DropdownMenuItem(
            text = { Text(text = "Drawing Colors") },
            onClick = {
                onDrawingColorClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Stroke Width")
            }
        )
        DropdownMenuItem(
            text = { Text(text = "Background Colors") },
            onClick = {
                onBackgroundColorClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "Stroke Width")
            }
        )
        DropdownMenuItem(
            text = { Text(text = "Setting") },
            onClick = {
                onSettingClick()
                onMenuDismiss()
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Settings, contentDescription = "Stroke Width")
            }
        )
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    WhiteBoardTheme {
        TopBar(
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

@Preview
@Composable
private fun MoreOptionsMenuPreview() {
    WhiteBoardTheme {
        MoreOptionsMenu(
            isExpanded = false,
            onMenuDismiss = { },
            onStrokeWidthClick = { },
            onDrawingColorClick = { },
            onBackgroundColorClick = { },
            onSettingClick = {}
        )
    }
}