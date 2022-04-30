package com.eol.memo2nd


// 위키시스템 간략버전이라도 도입....하려면 로그인시스템 구축해야함
// 로그인파트는 급 firebase 적용해서 구현중
// 계정생성 안됐었는데, 갑자기 또 돼냐?;;

// 품번입력시 디비에는 쩜빼고 등록
// 사이즈 소수점 입력하게 자료타입 설정.
// nullable 로해서 thickness 값도 등록하긔

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
            if(auth.currentUser == null)
                setMainFrag(5)
            else
                setMainFrag(4)

        }

    }

    private fun setMainFrag(fragNum : Int){

        val ft = supportFragmentManager.beginTransaction()

        when(fragNum){
            1 -> {
                ft.replace(R.id.mainFrame, BasicFragment()).commit()
            }
            2 -> {
                ft.replace(R.id.mainFrame, DisplayTest1Fragment()).commit()
            }
            3 -> {
                ft.replace(R.id.mainFrame, SearchTestFragment()).commit()
            }
            4 -> {
                ft.replace(R.id.mainFrame, MyPageFragment()).commit()
            }
            5 -> {
                ft.replace(R.id.mainFrame, LoginFragment()).commit()
            }

        }


    }

}


