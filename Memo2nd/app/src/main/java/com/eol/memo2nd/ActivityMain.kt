package com.eol.memo2nd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var toggle: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            if(toggle) binding.textView.text = "Bye Bye~!"
            else binding.textView.text = "Hello World!"
            toggle = !toggle
        }
    }
}

