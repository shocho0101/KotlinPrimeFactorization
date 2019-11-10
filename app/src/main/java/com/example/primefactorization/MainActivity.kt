package com.example.primefactorization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if (numberEditText.text.isEmpty()) {
                return@setOnClickListener
            }

            var number = numberEditText.text.toString().toInt()

            textView.text = when (number) {
                0, 1 -> number.toString()
                else -> factorization(number)
            }
        }
    }

    fun factorization(number: Int): String {
        var temp = number
        var text = ""
        for (i in 2..number) {
            while (temp % i == 0) {
                text += "$i×"
                temp /= i
            }
        }
        text = text.removeSuffix("×")

        return text
    }
}
