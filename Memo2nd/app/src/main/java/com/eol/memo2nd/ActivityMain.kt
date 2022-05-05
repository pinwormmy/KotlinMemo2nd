package com.eol.memo2nd


// 위키시스템 간략버전이라도 도입....하려면 로그인시스템 구축해야함
// 로그인 시스템 기본적인건 구현했는데, 이게 위키시스템이랑 연계가능한가?

// DB수정 혹은 새로 생성 염두해야함.
// 품번입력시 디비에는 쩜빼고 등록
// 사이즈 소수점 입력하게 자료타입 설정.
// nullable 로해서 thickness 값도 등록하긔
// 위키 시스템 연구해서 조금씩이라도 적용해보기

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        setMainFrag(1)

        binding.test1Button.setOnClickListener {
            setMainFrag(2)
        }

        binding.searchButton.setOnClickListener {
            setMainFrag(3)
        }

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


