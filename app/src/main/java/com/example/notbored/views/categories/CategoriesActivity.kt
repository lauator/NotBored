package com.example.notbored.views.categories

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notbored.data.dto.BoredCategory
import com.example.notbored.databinding.ActivityCategoriesBinding
import com.example.notbored.views.main.PARTICIPANTS_KEY
import com.example.notbored.views.sugestion.RANDOM
import com.example.notbored.views.sugestion.RANDOM_WITH_PARTICIPANTS
import com.example.notbored.views.sugestion.SuggestionActivity

const val CATEGORY = "categoria"


class CategoriesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoriesBinding
    private val viewModel: CategoriesViewModel by viewModels(
        factoryProducer = { CategoriesViewModelFactory() }
    )
    private lateinit var adapter: CategoryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoriesBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val participantes = this.intent.extras?.get(PARTICIPANTS_KEY)


        binding.ivRandom.setOnClickListener {
            val intentR = Intent(this, SuggestionActivity::class.java)
            intentR.putExtra(RANDOM,true)

            if(participantes != null){
                intentR.putExtra(PARTICIPANTS_KEY, participantes as Int)
                intentR.putExtra(RANDOM_WITH_PARTICIPANTS, true)
            }

            startActivity(intentR)
        }

        adapter = CategoryAdapter(object: CategoryAdapter.CategoryListener {
            override fun select(category: BoredCategory) {
                val intentS = Intent(this@CategoriesActivity, SuggestionActivity::class.java)
                intentS.putExtra(CATEGORY,category.id)
                if(participantes != null){
                    intentS.putExtra(PARTICIPANTS_KEY, participantes as Int)
                }
                startActivity(intentS)
            }
        })

        binding.categories.layoutManager = LinearLayoutManager(this)
        binding.categories.adapter = adapter

        viewModel.categories.observe(this) { newCategories ->
            this.adapter.setCategories(newCategories)
        }

        this.viewModel.load()

    }
}