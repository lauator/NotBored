package com.example.notbored.views.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notbored.data.categories.CategoriesRepository
import com.example.notbored.data.dto.BoredCategory

class CategoriesViewModel(private val repository: CategoriesRepository): ViewModel() {

    private val _categories = MutableLiveData<List<BoredCategory>>()
    val categories: LiveData<List<BoredCategory>>
        get() = _categories

    fun load() {
        val categories = this.repository.getCategories()
        this._categories.value = categories
    }

}