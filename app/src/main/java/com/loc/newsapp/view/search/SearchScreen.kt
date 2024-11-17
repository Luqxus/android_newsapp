package com.loc.newsapp.view.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.view.Dimensions
import com.loc.newsapp.view.common.ArticlesList
import com.loc.newsapp.view.common.SearchBar
import com.loc.newsapp.view.graph.Route
import com.loc.newsapp.view.search.viewModel.SearchEvent
import com.loc.newsapp.view.search.viewModel.SearchState


@Composable
fun SearchScreen(
    state: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = Dimensions.MediumPadding1,
                start = Dimensions.MediumPadding1,
                end = Dimensions.MediumPadding1
            ).statusBarsPadding()
    ) {

        SearchBar(
            text = state.searchQuery,
            readOnly = false,
            onValueChanged = {event(SearchEvent.UpdateSearchQuery(it))},
            onSearch = {event(SearchEvent.SearchNews)}
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))

        state.articles?.let {
            var articles = it.collectAsLazyPagingItems()

            ArticlesList(
                articles = articles,
                onClick = {
                    navigate(Route.DetailsScreen.route)
                }
            )
        }
    }
}