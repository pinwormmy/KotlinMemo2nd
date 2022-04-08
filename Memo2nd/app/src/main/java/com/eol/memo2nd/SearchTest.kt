package com.eol.memo2nd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.SearchTestBinding

class SearchTest : AppCompatActivity(){

    private val dbHelper = DBopenHelper(this,"Memo",null,1)

    // ViewBinding
    private lateinit var binding3 : SearchTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)


        binding3 = SearchTestBinding.inflate(layoutInflater)

        setContentView(binding3.root)


        val adapter = MemoAdapter()
        adapter.dbHelper = dbHelper

        binding3.searchResult.adapter = adapter
        binding3.searchResult.layoutManager = LinearLayoutManager(this)


        binding3.searchBarTest.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

                if(p0.toString() != "" || p0.toString() != null){

                    dbHelper.selectWhereMemo(p0.toString())
                    adapter.listData.clear()
                    adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                    adapter.notifyDataSetChanged()
                }else{
                    adapter.listData.clear()
                    adapter.notifyDataSetChanged()
                }
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p0.toString() != "" || p0.toString() != null){

                    dbHelper.selectWhereMemo(p0.toString())
                    adapter.listData.clear()
                    adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                    adapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(applicationContext, "입력없음", Toast.LENGTH_SHORT).show()
                    adapter.listData.clear()

                }
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString() != "" || p0.toString() != null){

                    dbHelper.selectWhereMemo(p0.toString())
                    adapter.listData.clear()
                    adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                    adapter.notifyDataSetChanged()
                }else{
                    // Toast.makeText(applicationContext, "입력없음", Toast.LENGTH_SHORT).show()
                    adapter.listData.clear()
                    adapter.notifyDataSetChanged()
                }
            }
        })

        binding3.searchToMainButton.setOnClickListener {

            finish()
        }
    }
}