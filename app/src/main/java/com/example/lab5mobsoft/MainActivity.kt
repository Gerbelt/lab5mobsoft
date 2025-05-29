package com.example.lab5mobsoft

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab5mobsoft.databinding.ActivityMainBinding
import android.widget.SeekBar
import android.content.Intent


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Обновление текста скидки при изменении ползунка
        binding.seekBarDiscount.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                binding.textViewDiscountLabel.text = "Скидка: $progress%"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        // Обработка нажатия на кнопку "ОК"
        binding.buttonCalculate.setOnClickListener {
            val hoursText = binding.editTextHours.text.toString()
            val hours = hoursText.toIntOrNull() ?: 0
            val discount = binding.seekBarDiscount.progress

            // Базовая ставка: 100 руб/час
            val baseRate = 100
            val total = (hours * baseRate * (1 - discount / 100.0)).toInt()

            // Переход на вторую активность с передачей суммы
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("total_amount", total)
            startActivity(intent)
        }
    }
}