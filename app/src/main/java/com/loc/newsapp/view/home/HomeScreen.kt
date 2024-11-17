package com.loc.newsapp.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loc.newsapp.domain.model.Article
import com.loc.newsapp.view.Dimensions
import com.loc.newsapp.R
import com.loc.newsapp.view.common.ArticlesList
import com.loc.newsapp.view.common.SearchBar
import com.loc.newsapp.view.graph.Route


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 0) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive =  9))
                    .joinToString(separator = " \uD83d\uDFE5 "){it.title}
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(top = Dimensions.MediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = Dimensions.MediumPadding2)
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))

        SearchBar(
            modifier = Modifier.padding(horizontal = Dimensions.MediumPadding1),
            text = "",
            readOnly = true,
            onValueChanged = {},
            onClick = {},
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))


        Text(
            text =  titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = Dimensions.MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder),
        )

        Spacer(modifier = Modifier.height(Dimensions.MediumPadding1))


        ArticlesList(
            modifier = Modifier.padding(horizontal = Dimensions.MediumPadding1),
            articles = articles,
            onClick = {
                navigate(Route.DetailsScreen.route)
            }
        )


    }

}