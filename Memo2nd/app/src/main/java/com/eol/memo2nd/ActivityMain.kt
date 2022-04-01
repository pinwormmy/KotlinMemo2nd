package com.eol.memo2nd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.ActivityMainBinding
import com.eol.memo2nd.databinding.ItemRecyclerBinding

class MainActivity : AppCompatActivity() {

    val dbHelper = DBopenHelper(this,"Memo",null,1)

    // ViewBinding
    private lateinit var binding : ActivityMainBinding

    // RecyclerView 가 불러올 목록
    // private val data:MutableList<Memo> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

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
    }
}
/*
    private fun refreshRecyclerView(){
        val adapter = MemoAdapter()
        adapter.listData = data
        binding.recyclerView.adapter = adapter
        // binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
*/

