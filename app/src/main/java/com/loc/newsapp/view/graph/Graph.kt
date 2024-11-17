package com.loc.newsapp.view.graph

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.paging.compose.collectAsLazyPagingItems
import com.loc.newsapp.view.home.HomeScreen
import com.loc.newsapp.view.home.viewModel.HomeViewModel
import com.loc.newsapp.view.onboarding.OnboardingScreen
import com.loc.newsapp.view.onboarding.viewModel.OnboardingViewModel
import com.loc.newsapp.view.search.SearchScreen
import com.loc.newsapp.view.search.viewModel.SearchViewModel


@Composable
fun Graph(
    startDestination: String,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        startDestination = startDestination,
        navController = navController
    ) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnboardingScreen.route
        ) {
            composable(
                route = Route.OnboardingScreen.route
            ) {
                val onboardingViewModel: OnboardingViewModel = hiltViewModel<OnboardingViewModel>()

                OnboardingScreen(
                    event = onboardingViewModel::onEvent
                )

            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(
                route = Route.NewsNavigatorScreen.route
            ) {

//                val homeViewModel: HomeViewModel = hiltViewModel()
//                val articles = homeViewModel.news.collectAsLazyPagingItems()
//
//                HomeScreen(articles = articles, navigate = {})

                val searchViewModel: SearchViewModel = hiltViewModel()
                SearchScreen(state = searchViewModel.state.value, event = searchViewModel::onEvent, navigate = {})
            }
        }
    }
}