package com.example.notbored.views.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.notbored.views.terms.TermsAndConditionsActivity
import com.example.notbored.databinding.ActivityMainBinding
import com.example.notbored.views.categories.CategoriesActivity

const val PARTICIPANTS_KEY = "numero_de_participantes"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnStart.setOnClickListener {
            val intent = Intent(this, CategoriesActivity::class.java)
            if(binding.tietParticipants.text.toString().isNotEmpty()){
                intent.putExtra(PARTICIPANTS_KEY, binding.tietParticipants.text.toString().toInt())

            }
            startActivity(intent)
        }

        binding.tvTerms.setOnClickListener {
            val intent = Intent(this, TermsAndConditionsActivity::class.java)
            startActivity(intent)

        }





        binding.tietParticipants.addTextChangedListener {
            binding.btnStart.isEnabled = it.toString().isNotEmpty() && it.toString().toInt() != 0
        }




    }
}