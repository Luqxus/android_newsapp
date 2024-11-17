package com.loc.newsapp.view.onboarding.Composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.loc.newsapp.ui.theme.BlueGray
import com.loc.newsapp.view.Dimensions


@Composable
fun ViewIndicator(
    modifier: Modifier = Modifier,
    viewSize: Int,
    selectedView: Int,
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = BlueGray
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(viewSize) { viewIndex ->
            Box (
                modifier = Modifier
                    .size(Dimensions.IndicatorSize)
                    .clip(CircleShape)
                    .background(color = if (viewIndex == selectedView) selectedColor else unselectedColor)
            ) {

            }
        }
    }
}