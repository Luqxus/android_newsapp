package com.loc.newsapp.view.onboarding.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.loc.newsapp.domain.manager.usercases.app_entry.AppEntryUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val appEntryUseCases: AppEntryUseCases
) : ViewModel() {

    fun onEvent(event: OnboardingEvent) {
        when(event) {
            is OnboardingEvent.SaveAppEntry -> saveAppEntry()
        }
    }

    private fun saveAppEntry() {
        viewModelScope.launch {
            appEntryUseCases.saveAppEntry()
        }
    }
}