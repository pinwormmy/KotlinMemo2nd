package com.eol.memo2nd


// 위키시스템 간략버전이라도 도입....하려면 로그인시스템 구축해야함

// Room 적용 중...리싸이클러뷰 연동해서 해야함


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


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


