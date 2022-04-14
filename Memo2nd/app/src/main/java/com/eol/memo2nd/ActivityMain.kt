package com.eol.memo2nd

// 여기다가 러그투러그에 구현하려고 하는 기능들 하나씩 공부하면서 적용해보고 할만큼했다 싶으면 어플 새로 만들자
// 작성 페이지는 프레그먼트 적용해서 따로 만들자.

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {



    // ViewBinding
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, DisplayTest1Fragment::class.java)
        val intent2 = Intent(this, SearchTestFragment::class.java)

        setContentView(binding.root)

        setMainFrag(0)



/*
        binding.saveButton.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                val memo = Memo(null, binding.editMemo.text.toString(), binding.editMemo.text.toString(), binding.editMemo.text, binding.editMemo.text, System.currentTimeMillis())
                dbHelper.insertMemo(memo)
            }
            adapter.listData.clear()
            adapter.listData.addAll(dbHelper.selectMemo())

            adapter.notifyDataSetChanged()
            binding.editMemo.setText("")
        }
*/
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
                ft.replace(R.id.mainFrame, BasicFragment()).commit()
            }
        }
    }

}


