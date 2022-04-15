package com.eol.memo2nd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.SearchTestBinding

class SearchTestFragment : Fragment(){

    // private val dbHelper = DBopenHelper(this,"Memo",null,1)

    // ViewBinding
    private lateinit var binding3 : SearchTestBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        // ViewBinding
        super.onCreate(savedInstanceState)


        binding3 = SearchTestBinding.inflate(layoutInflater)
/*
        setContentView(binding3.root)

         val adapter = MemoAdapter()
         adapter.dbHelper = dbHelper

         binding3.searchResult.adapter = adapter
         binding3.searchResult.layoutManager = LinearLayoutManager(this)


         binding3.searchBarTest.addTextChangedListener(object : TextWatcher {
             override fun afterTextChanged(p0: Editable?) {

                 if(p0.toString() == "" || p0.toString() == null){
                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereMemo(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 if(p0.toString() == "" || p0.toString() == null){

                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereMemo(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
             override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 if(p0.toString() == "" || p0.toString() == null){

                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereMemo(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereMemo(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
         })
*/
    }
}