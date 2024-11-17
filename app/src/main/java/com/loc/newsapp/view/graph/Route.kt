package com.loc.newsapp.view.graph

sealed class Route(
    val route: String
) {
    object OnboardingScreen: Route(route = "onboarding_screen")
    object HomeScreen : Route(route = "home_screen")
    object SearchScreen: Route(route = "search_screen")
    object BookmarkScreen: Route(route = "bookmark_screen")
    object DetailsScreen: Route(route = "details_screen")
    object AppStartNavigation: Route(route = "app_start_navigation")
    object NewsNavigation: Route(route = "news_navigation")
    object NewsNavigatorScreen: Route(route = "news_navigator")
}