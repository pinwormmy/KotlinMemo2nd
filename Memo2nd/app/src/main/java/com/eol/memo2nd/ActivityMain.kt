package com.eol.memo2nd


// 위키시스템 간략버전이라도 도입....하려면 로그인시스템 구축해야함
// 로그인파트는 급 firebase 적용해서 구현중
// 로그인 상태랑 비로그인 상태 구분 적용해야하는데, 페이지 구성새로해야함.
// 로그인 버튼이 아니라, 회원버튼으로 수정하고, 비로긴이면 로그인페이지, 로그인이면 회원페이지(로그아웃버튼 포함)로 이동하게


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
/*  이 부분 레이아웃 아예 두개로 나눠서 관리
        if(auth.currentUser == null){
            binding.buttonToLogin.visibility = View.VISIBLE
            binding.buttonToLogOut.visibility = View.INVISIBLE
            binding.loginStatus.text = "로그인할 수도 있쥐"
        }
        else{
            binding.buttonToLogin.visibility = View.INVISIBLE
            binding.buttonToLogOut.visibility = View.VISIBLE
            binding.loginStatus.text = auth.currentUser?.email
        }

        로그인 버튼은 회원관리 버튼으로 통합 프래그먼트 옮겨서 로그인을 하든 로그아웃하든
        binding.buttonToLogin.setOnClickListener {
            setMainFrag(0)
        }

        binding.buttonToLogOut.setOnClickListener {

            auth.signOut()
        }
*/
        setMainFrag(1)

        binding.test1Button.setOnClickListener {
            setMainFrag(2)
        }

        binding.searchButton.setOnClickListener {
            setMainFrag(3)
        }

        binding.addWatchButton.setOnClickListener{
            setMainFrag(4)
        }
    }

    private fun setMainFrag(fragNum : Int){

        val ft = supportFragmentManager.beginTransaction()

        when(fragNum){
            0 -> {
                ft.replace(R.id.mainFrame, LoginFragment()).commit()
            }
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
                ft.replace(R.id.mainFrame, AddWatchFragment()).commit()
            }

        }


    }

}


