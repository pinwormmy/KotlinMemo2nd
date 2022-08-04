package com.eol.memo2nd

// 카메라 연동 (카메라 키기 - 찍기 - 찍은 파일 디비에 바로 넣기)
// 이미지(카메라 촬영본) 위에 표시 기능
// 디비 마이그레이션

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        // 문법 확인
        setMainFrag(1)
        binding.test1Button.setOnClickListener{setMainFrag(2)}
        binding.searchButton.setOnClickListener{setMainFrag(3)}
        binding.buttonMyPage.setOnClickListener {
            if(auth.currentUser == null) setMainFrag(5)
            else setMainFrag(4)
        }
    }

    private fun setMainFrag(fragNum : Int){

        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            1 -> ft.replace(R.id.mainFrame, BasicFragment()).commit()
            2 -> ft.replace(R.id.mainFrame, DisplayTest1Fragment()).commit()
            3 -> ft.replace(R.id.mainFrame, SearchTestFragment()).commit()
            4 -> ft.replace(R.id.mainFrame, MyPageFragment()).commit()
            5 -> ft.replace(R.id.mainFrame, LoginFragment()).commit()
        }
    }
}


