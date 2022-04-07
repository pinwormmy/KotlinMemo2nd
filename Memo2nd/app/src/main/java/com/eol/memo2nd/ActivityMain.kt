package com.eol.memo2nd

// 여기다가 러그투러그에 구현하려고 하는 기능들 하나씩 공부하면서 적용해보고 할만큼했다 싶으면 어플 새로 만들자

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val dbHelper = DBopenHelper(this,"Memo",null,1)

    // ViewBinding
    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)

        val intent = Intent(this, DisplayTest1::class.java)
        val intent2 = Intent(this, SearchTest::class.java)

        setContentView(binding.root)


        val adapter = MemoAdapter()
        adapter.listData.addAll(dbHelper.selectMemo())
        adapter.dbHelper = dbHelper

        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)


        binding.saveButton.setOnClickListener {
            if (binding.editMemo.text.toString().isNotEmpty()) {
                val memo = Memo(null, binding.editMemo.text.toString(), System.currentTimeMillis())
                dbHelper.insertMemo(memo)
            }
            adapter.listData.clear()
            adapter.listData.addAll(dbHelper.selectMemo())

            adapter.notifyDataSetChanged()
            binding.editMemo.setText("")
        }

        binding.test1Button.setOnClickListener {

            startActivity(intent)
        }

        binding.searchButton.setOnClickListener {

            startActivity(intent2)
        }

    }



}


