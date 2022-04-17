package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.AddWatchBinding
import com.eol.memo2nd.databinding.WatchListFragmentBinding
import com.eol.watch2nd.DBopenHelper

class AddWatchFragment() : Fragment() {

    lateinit var binding: AddWatchBinding

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var dbHelper: DBopenHelper = DBopenHelper(mainActivity,"Watch",null,1)

        binding = AddWatchBinding.inflate(inflater, container, false)

        val adapter = MemoAdapter()
        adapter.listData.addAll(dbHelper.selectWatch())
        adapter.dbHelper = dbHelper

        binding.watchListRecycler.adapter = adapter
        binding.watchListRecycler.layoutManager = LinearLayoutManager(mainActivity)


        binding.saveButton.setOnClickListener {
            if (binding.writeBrand.text.toString().isNotEmpty() and binding.writeNameText.text.toString().isNotEmpty()
                and binding.writeCaseSizeText.text.isNotEmpty() and binding.writeLugtoLugText.text.isNotEmpty()) {
                val watch = Watch(null, binding.writeBrand.text.toString(), binding.writeNameText.text.toString(),
                    Integer.parseInt(binding.writeCaseSizeText.text.toString()),Integer.parseInt(binding.writeLugtoLugText.text.toString()), System.currentTimeMillis())
                dbHelper.addWatch(watch)
            }
            adapter.listData.clear()
            adapter.listData.addAll(dbHelper.selectWatch())

            adapter.notifyDataSetChanged()
            binding.writeBrand.setText("")
            binding.writeNameText.setText("")
            binding.writeCaseSizeText.setText("")
            binding.writeLugtoLugText.setText("")
        }
        return binding.root
    }

}