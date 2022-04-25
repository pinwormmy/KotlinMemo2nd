package com.eol.memo2nd


// 위키시스템 간략버전이라도 도입....하려면 로그인시스템 구축해야함

// Room 라이브러리 적용 예정. 아직 공부만 하는 중
// 수정하기 어려워 아마 프로젝트 새로 파야할 것으로 보인다
// 실물크기 구현하는 기능


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.watch2nd.DBopenHelper

class MainActivity : AppCompatActivity() {

    // ViewBinding
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMainFrag(0)

        binding.test1Button.setOnClickListener {
            setMainFrag(1)
        }

        binding.searchButton.setOnClickListener {
            setMainFrag(2)
        }

        binding.addWatchButton.setOnClickListener{
            setMainFrag(3)
        }
    }

    private fun setMainFrag(fragNum : Int){

        val ft = supportFragmentManager.beginTransaction()

        when(fragNum){
            0 -> {
                ft.replace(R.id.mainFrame, BasicFragment()).commit()
            }
            1 -> {
                ft.replace(R.id.mainFrame, DisplayTest1Fragment()).commit()
            }
            2 -> {
                ft.replace(R.id.mainFrame, SearchTestFragment()).commit()
            }
            3 -> {
                ft.replace(R.id.mainFrame, AddWatchFragment()).commit()
            }
        }


    }

}


