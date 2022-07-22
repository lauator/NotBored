package com.example.notbored.views.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notbored.data.dto.BoredCategory
import com.example.notbored.databinding.CategoryListItemBinding

class CategoryAdapter(
    val listener: CategoryListener
): RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    interface CategoryListener {
        fun select(category: BoredCategory)
    }

    private var categories = mutableListOf<BoredCategory>()

    fun setCategories(newCategories: List<BoredCategory>) {
        categories.clear()
        categories.addAll(newCategories)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CategoryListItemBinding.inflate(layoutInflater,parent,false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(private val binding: CategoryListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(category: BoredCategory) {
            binding.categoryName.text = category.name
            binding.root.setOnClickListener {
                listener.select(category)
            }
        }

    }
}