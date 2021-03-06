package com.example.lab1.ui.utils

import androidx.annotation.DrawableRes
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.MaterialTheme
import androidx.ui.material.OutlinedButton
import androidx.ui.material.TextButton
import androidx.ui.material.surface.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp

@Composable
fun DrawerButton(
    modifier: Modifier = Modifier.None,
    @DrawableRes icon: Int,
    label: String,
    isSelected: Boolean,
    onClickAction: () -> Unit
) {
    val colors = MaterialTheme.colors()

    val textIconColor = if (isSelected) colors.primary else colors.onSurface.copy(alpha = 0.6f)
    val backgroundColor = if (isSelected) colors.primary.copy(alpha = 0.12f) else colors.surface

    val surfaceModifier = modifier +
            LayoutPadding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp) +
            LayoutWidth.Fill

    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = RoundedCornerShape(4.dp)
    ) {
        TextButton(
            onClick = onClickAction,
            modifier = LayoutWidth.Fill
        ) {
            Row(
                arrangement = Arrangement.Start,
                modifier = LayoutWidth.Fill
            ) {
                VectorImage(
                    modifier = LayoutGravity.Center,
                    id = icon,
                    tint = textIconColor
                )

                Spacer(modifier = LayoutWidth(16.dp))

                Text(
                    text = label,
                    style = mainThemeTypography.body2.copy(color = textIconColor)
                )
            }
        }
    }
}

@Composable
fun DialNumberButton(
    text: String,
    modifier: Modifier = LayoutSize(width = 100.dp, height = 50.dp) + LayoutPadding(4.dp),
    onClickAction: () -> Unit
) {
    OutlinedButton(
        onClick = onClickAction,
        modifier = modifier,
        shape = MaterialTheme.shapes().button
    ) {
        Text(text = text, style = mainThemeTypography.h6)
    }
}

@Composable
fun DialFunctionalButton(
    @DrawableRes icon: Int,
    modifier: Modifier = LayoutSize(width = 100.dp, height = 50.dp) + LayoutPadding(4.dp),
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        shape = MaterialTheme.shapes().button
    ) {
        VectorImage(
            id = icon
        )
    }
    
}

@Preview
@Composable
fun PreviewDialNumberButton() {
    ThemedPreview() {
        DialNumberButton(text = "5", onClickAction = { })
    }
}