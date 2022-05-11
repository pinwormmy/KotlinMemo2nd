package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.WatchListFragmentBinding

class BasicFragment : Fragment() {

    lateinit var binding: WatchListFragmentBinding

    var db : AppDataBase? = null
    var watchList = mutableListOf<WatchEntity>()

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = WatchListFragmentBinding.inflate(inflater, container, false)
        db = AppDataBase.getInstance(mainActivity)

        val savedWatch = db!!.watchDAO().showAll()
        if(savedWatch.isNotEmpty()) watchList.addAll(savedWatch)
        val adapter = WatchAdapter(watchList)

        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(mainActivity)

        return binding.root
    }

}