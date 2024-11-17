package com.loc.newsapp.view.search.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.domain.manager.usercases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    private val _state  = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


     fun onEvent(event: SearchEvent) {
         when(event) {
             is SearchEvent.SearchNews -> searchNews()

             is SearchEvent.UpdateSearchQuery -> {

                 _state.value = state.value.copy(searchQuery = event.searchQuery)

             }
         }
     }


    private fun searchNews() {
        val articles = newsUseCases.searchNews(
            searchQuery = _state.value.searchQuery,
            sources = listOf("bbc-news", "abc-news")
        ).cachedIn(viewModelScope)

        _state.value = _state.value.copy(articles =  articles)
    }
}