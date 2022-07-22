package com.example.notbored.views.terms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notbored.R
import com.example.notbored.databinding.ActivityTermsAndConditionsBinding
import com.example.notbored.views.main.MainActivity

class TermsAndConditionsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityTermsAndConditionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTermsAndConditionsBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.ivClose.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }
}