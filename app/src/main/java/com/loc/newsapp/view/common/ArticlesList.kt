package com.loc.newsapp.view.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.view.Dimensions


@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {

    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding1),
            contentPadding = PaddingValues(all = Dimensions.ExtraSmallPadding2)
        ) {

            items(count = articles.itemCount) { index: Int ->
                articles[index]?.let{article ->
                    ArticleCard(article = article, onClick = {})
                }
            }

        }
    }

}

@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>
) : Boolean {
    val loadState = articles.loadState

    var error = when{
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }

    return when{
        loadState.refresh is LoadState.Loading-> {
            ShimmerEffect()
            false
        }

        error!= null -> {
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}


@Composable
private fun ShimmerEffect() {
    Column(
        verticalArrangement = Arrangement.spacedBy(Dimensions.MediumPadding1)
    ) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = Dimensions.MediumPadding2)
            )
        }
    }
}