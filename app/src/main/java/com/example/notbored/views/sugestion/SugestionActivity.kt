package com.example.notbored.views.sugestion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.notbored.R
import com.example.notbored.databinding.ActivitySuggestionBinding
import com.example.notbored.views.categories.CATEGORY
import com.example.notbored.views.categories.CategoriesActivity
import com.example.notbored.views.main.MainActivity
import com.example.notbored.views.main.PARTICIPANTS_KEY

const val RANDOM = "es_random"
const val RANDOM_WITH_PARTICIPANTS = "es_random_con_participantes"


class SuggestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuggestionBinding

    private val viewModel: SuggestionViewModel by viewModels(
        factoryProducer = { SuggestionViewModelFactory() }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val isRandom = intent.extras?.get(RANDOM)
        val isRandomWithParticipants = intent.extras?.get(RANDOM_WITH_PARTICIPANTS)
        val numberOfParticipants = intent.extras?.get(PARTICIPANTS_KEY)
        val category = intent.extras?.get(CATEGORY)


        viewModel.activity.observe(this) { suggestion ->

            if (suggestion != null) {
                if(isRandom != null && isRandom as Boolean){
                    binding.tvCategory.text = "Random"
                }else{
                    binding.tvCategory.text = category as String
                }
                binding.tvTitle.text = suggestion.activity

                binding.tvParticipants.text = suggestion.participants.toString()
                when {
                    suggestion.price == 0.0 -> binding.tvPrice.text = "Free"
                    suggestion.price > 0.0 && suggestion.price <= 0.3 -> binding.tvPrice.text = "Low"
                    suggestion.price > 0.3 && suggestion.price <= 0.6 -> binding.tvPrice.text =
                        "Medium"
                    suggestion.price > 0.6 -> binding.tvPrice.text = "High"
                }

                if(isRandom != null && isRandom as Boolean ){
                    binding.tvRandomSuggestion.text = suggestion.type

                }

            }

        }


if(isRandom != null && isRandom as Boolean && isRandomWithParticipants != null && !(isRandomWithParticipants as Boolean)){
    viewModel.loadRandom()
}else if(isRandom != null && isRandom as Boolean && isRandomWithParticipants != null && isRandomWithParticipants as Boolean){
    viewModel.loadRandomParticipants(numberOfParticipants as Int)
}else if(numberOfParticipants != null){
    viewModel.load(numberOfParticipants as Int, category as String)
}else if(numberOfParticipants == null && isRandom == null){
    viewModel.loadWithOutParticipants(category as String)
}




        binding.btnTry.setOnClickListener {
            if(isRandom != null && isRandom as Boolean && isRandomWithParticipants != null && !(isRandomWithParticipants as Boolean)){
                viewModel.loadRandom()
            }else if(isRandom != null && isRandom as Boolean && isRandomWithParticipants != null && isRandomWithParticipants as Boolean){
                viewModel.loadRandomParticipants(numberOfParticipants as Int)
            }else if(numberOfParticipants != null){
                viewModel.load(numberOfParticipants as Int, category as String)
            }else if(numberOfParticipants == null && isRandom == null){
                viewModel.loadWithOutParticipants(category as String)
            }
        }

        binding.icBack.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }


    }
}