package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.SearchTestBinding

class SearchTestFragment : Fragment(){
    // ViewBinding
    private lateinit var binding3 : SearchTestBinding

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    var db : AppDataBase? = null
    var watchList = mutableListOf<WatchEntity>()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // ViewBinding
        super.onCreate(savedInstanceState)

        binding3 = SearchTestBinding.inflate(layoutInflater)

        // db 초기화
        db = AppDataBase.getInstance(mainActivity)

        val savedWatch = db!!.watchDAO().showAll()
        if(savedWatch.isNotEmpty()){
            watchList.addAll(savedWatch)
        }

        val adapter = WatchAdapter(watchList)

        binding3.searchBarTest.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(p0: Editable?) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO()?.showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO()?.showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO()?.showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }
        })

        binding3.searchResult.adapter = adapter
        binding3.searchResult.layoutManager = LinearLayoutManager(mainActivity)

        return binding3.root
    }
}