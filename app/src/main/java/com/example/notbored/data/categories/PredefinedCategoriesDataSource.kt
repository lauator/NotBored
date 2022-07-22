package com.example.notbored.data.categories

import com.example.notbored.data.dto.BoredCategory

class PredefinedCategoriesDataSource {

    private val categories: List<BoredCategory> = listOf(
        BoredCategory("education","Educacion"),
        BoredCategory("recreational","Recreacional"),
        BoredCategory("social","Social"),
        BoredCategory("diy","Bricolaje"),
        BoredCategory("charity","Caridad"),
        BoredCategory("cooking","Cocina"),
        BoredCategory("relaxation","Relajacion"),
        BoredCategory("music","Musica"),
        BoredCategory("busywork","Trabajo")
    )



    fun getCategories(): List<BoredCategory> {
        return categories
    }
}