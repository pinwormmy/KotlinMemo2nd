package com.eol.memo2nd

// 여기다가 러그투러그에 구현하려고 하는 기능들 하나씩 공부하면서 적용해보고 할만큼했다 싶으면 어플 새로 만들자
// 검색창에 엔터치면 줄띄움되는거 안되게하고
// 연관검색어 기능 넣기

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.watch2nd.DBopenHelper

class MainActivity : AppCompatActivity() {

    private val dbHelper = DBopenHelper(this,"Watch",null,1)

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


