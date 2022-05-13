package com.eol.memo2nd

// 이전에 구글 로그인 적용해보긔 - 생각보다 적용 코드가 까다롭다? 공부 좀 하고 적용하긔
// 품번입력시 디비에는 쩜이랑 특문 빼고 등록하게끔(아니면 알아서 제외시켜 등록하는쪽으로) <- 이거 어떻게 처리할거야
// 사이즈 소수점 입력하게 자료타입 설정. nullable 로해서 thickness 값도 등록하긔
// 그래서, DB개편이 필요한데, room 새 버전할지, 아니면 firebase 쓸지, 위키시스템과 DB연계 상황을 보고 결정
// 그래서 위키시스템 어떻게 구성할지부터 결정해야함. 정정요청시스템에 따로 db구조 바꿀 필요없으면 그대로 간다

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


