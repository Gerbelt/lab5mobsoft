package com.example.lab5mobsoft

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab5mobsoft.databinding.ActivitySecondBinding



class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val amount = intent.getIntExtra("total_amount", 0)
        binding.textViewResult.text = "Оплатить = $amount рублей"
    }
}
