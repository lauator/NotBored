package com.example.notbored.views.categories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notbored.data.categories.CategoriesRepository
import com.example.notbored.data.categories.PredefinedCategoriesDataSource

class CategoriesViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dataSource = PredefinedCategoriesDataSource()
        val repository = CategoriesRepository(dataSource)
        return  CategoriesViewModel(repository) as T
    }
}