package com.example.meat.components.checkbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.triStateToggleable
import androidx.compose.material.Surface
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.meat.drawable.DrawableResources


@Composable
fun HeartCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(CheckboxSize)
            .padding(CheckboxDefaultPadding)
            .triStateToggleable(
                role = Role.Checkbox,
                interactionSource = remember { MutableInteractionSource() },
                state = ToggleableState(checked),
                indication = rememberRipple(
                    bounded = false,
                    radius = CheckboxRippleRadius,
                ),
                onClick = {
                    onCheckedChange(!checked)
                }
            ),
        color = Color.Transparent
    ) {
        Image(
            painter = if (checked) {
                painterResource(id = DrawableResources.SolidHeart.id)
            } else {
                painterResource(id = DrawableResources.OutlinedHeart.id)
            },
            contentDescription = "heartCheckbox",
        )
    }
}


private val CheckboxRippleRadius = 24.dp
private val CheckboxDefaultPadding = 2.dp
private val CheckboxSize = 30.dp