package com.example.homework_2

import android.location.Location.convert
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.homework_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: com.example.homework_2.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.button.setOnClickListener {
            val userInputNum = binding.editTextTextPersonName.text.toString()
            val numberConveter = NumberToWordsConverter()



            binding.textView.text = numberConveter.convert(userInputNum.toInt())
        }
    }

    class NumberToWordsConverter {

        var units = listOf(
            "", "ერთი", "ორი", "სამი", "ოთხი",
            "ხუთი", "ექვსი", "შვიდი", "რვა", "ცხრა", "ათი", "თერთმეტი", "თორმეტი",
            "ცამეტი", "თოთხმეტი", "თხუტმეტი", "თექვსმეტი", "ჩვიდმეტი",
            "თვრამეტი", "ცხრამეტი"
        )


        var tens = listOf(
            "",        // 0
            "",        // 1
            "ოცდა",    // 2
            "ოცდა",    // 3
            "ორმოცდა",    // 4
            "ორმოცდა",    // 5
            "სამოცდა",    // 6
            "სამოცდა",    // 7
            "ოთხმოცდა",    // 8
            "ოთხმოცდა"    // 9
        )

        var hundred = listOf(
            "",
            "ას",
            "ორას",
            "სამას",
            "ოთხას",
            "ხუთას",
            "ექვსას",
            "შვიდას",
            "რვაას",
            "ცხრაას"
        )


        fun convert(n: Int): String {
            if (n < 0) {
                return "მინუს" + convert(-n);
            }
            if (n < 20) {
                return units[n]
            }



            if (n < 100) {
                return tens[n / 10] + units[n % 20]
            }

            if (n == 100 || n == 200 || n == 300 || n == 400 || n == 500 || n == 600 || n == 700
                || n == 800 || n == 900) {
                return hundred[n/100] + "ი"
            }


            return hundred[n / 100] + (if (n % 100 !== 0) "" else "") + convert(n % 100)


        }
    }

}
