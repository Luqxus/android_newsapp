package com.loc.newsapp.view.common

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.loc.newsapp.R
import com.loc.newsapp.view.Dimensions


fun Modifier.shimmerEffect(): Modifier = composed {
    val transition = rememberInfiniteTransition(label= "InfiniteTransition")

    val alpha  = transition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.9f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label= "FloatAnimation"
    ).value

    this.then(
        background(color = colorResource(id = R.color.shimmer).copy(alpha = alpha))
    )
}

@Composable
fun ArticleCardShimmer() {
    Row(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .size(Dimensions.ArticleCardSize)
                .clip(MaterialTheme.shapes.medium).shimmerEffect(),
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = Dimensions.ExtraSmallPadding)
                .height(Dimensions.ArticleCardSize)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .padding(horizontal = Dimensions.MediumPadding1)
                    .shimmerEffect()
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.5f)
                        .height(15.dp)
                        .padding(horizontal = Dimensions.MediumPadding1)
                        .shimmerEffect()
                )
            }

        }
    }

}