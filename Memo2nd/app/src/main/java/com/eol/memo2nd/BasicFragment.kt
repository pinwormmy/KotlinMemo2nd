package com.eol.memo2nd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.WatchListFragmentBinding

class BasicFragment : Fragment() {

    // private val dbHelper = DBopenHelper(this,"Watch",null,1)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = WatchListFragmentBinding.inflate(inflater, container, false)

        val adapter = MemoAdapter()
        adapter.listData.addAll(dbHelper.selectMemo())
        adapter.dbHelper = dbHelper

        binding.recyclerMemo.adapter = adapter
        binding.recyclerMemo.layoutManager = LinearLayoutManager(this)

        return binding.root
    }

}