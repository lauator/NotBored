package com.example.notbored.views.sugestion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.data.suggestion.BoredSuggestionRemoteDataSource
import com.example.notbored.data.suggestion.BoredSuggestionRepository

class SuggestionViewModelFactory: ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = BoredSuggestionRemoteDataSource()
        val repository = BoredSuggestionRepository(dataSource)
        return SuggestionViewModel(repository) as T

    }


}