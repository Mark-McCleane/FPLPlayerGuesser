package com.example.fantasyfootballgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fantasyfootballgame.repository.FplEventRepository
import com.example.fantasyfootballgame.repository.FplPlayerRepository

class MainActivityViewModelProviderFactory(
    val fplPlayerRepository: FplPlayerRepository,
    val fplEventRepository: FplEventRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(fplPlayerRepository, fplEventRepository) as T
    }
}