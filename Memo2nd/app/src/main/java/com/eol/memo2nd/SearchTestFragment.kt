package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.SearchTestBinding
import com.eol.watch2nd.DBopenHelper

class SearchTestFragment : Fragment(){
    // ViewBinding
    private lateinit var binding3 : SearchTestBinding

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // ViewBinding
        super.onCreate(savedInstanceState)

        val dbHelper = DBopenHelper(mainActivity,"Watch",null,2)


        binding3 = SearchTestBinding.inflate(layoutInflater)

         val adapter = MemoAdapter()
         adapter.dbHelper = dbHelper

         binding3.searchResult.adapter = adapter
         binding3.searchResult.layoutManager = LinearLayoutManager(mainActivity)


         binding3.searchBarTest.addTextChangedListener(object : TextWatcher {
             override fun afterTextChanged(p0: Editable?) {

                 if(p0.toString() == "" || p0.toString() == null){
                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereWatch(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereWatch(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
             override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 if(p0.toString() == "" || p0.toString() == null){

                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereWatch(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereWatch(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
             override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                 if(p0.toString() == "" || p0.toString() == null){

                     adapter.listData.clear()

                 }else{
                     dbHelper.selectWhereWatch(p0.toString())
                     adapter.listData.clear()
                     adapter.listData.addAll(dbHelper.selectWhereWatch(p0.toString()))
                     adapter.notifyDataSetChanged()
                 }
             }
         })

        return binding3.root
    }
}