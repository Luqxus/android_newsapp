package com.loc.newsapp.view.search.viewModel

sealed  class SearchEvent {

    data class UpdateSearchQuery(val searchQuery: String) : SearchEvent()


    object SearchNews : SearchEvent()
}