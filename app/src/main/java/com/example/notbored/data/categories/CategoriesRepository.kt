package com.example.notbored.data.categories

import com.example.notbored.data.dto.BoredCategory

class CategoriesRepository(private val dataSource: PredefinedCategoriesDataSource) {

    fun getCategories(): List<BoredCategory> {
        return this.dataSource.getCategories()
    }
}