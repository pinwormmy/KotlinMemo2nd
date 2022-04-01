package com.eol.memo2nd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    var toggle: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)

        val view = mainBinding.root
        setContentView(view)

        mainBinding.button.setOnClickListener {
            if(toggle) mainBinding.textView.text = "원래는 바인드뷰 테스트용이야"
            else mainBinding.textView.text = "안뇽 월드~!~!"
            toggle = !toggle
        }
    }
}

