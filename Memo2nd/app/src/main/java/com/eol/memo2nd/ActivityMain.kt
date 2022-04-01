package com.eol.memo2nd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // ViewBinding
    private lateinit var binding : ActivityMainBinding

    // RecyclerView 가 불러올 목록
    private val data:MutableList<Memo> = mutableListOf()

    var i = 4

    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        initialize() // data 값 초기화
        refreshRecyclerView() // recyclerView 데이터 바인딩

        // FAB 을 누르면 Member + 숫자의 문자열이 data 배열에 추가됨
        binding.fab.setOnClickListener {
            val string = "Memo$i"
            i++
            data.add(Memo(string))
            refreshRecyclerView()
        }
    }
    private fun initialize(){
        with(data){
            add(Memo("Memo1"))
            add(Memo("Memo2"))
            add(Memo("Memo3"))
        }
    }
    private fun refreshRecyclerView(){
        val adapter = MemoAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}


