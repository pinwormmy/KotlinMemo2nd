package com.eol.memo2nd

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.AddWatchBinding
import com.google.firebase.auth.FirebaseAuth

class AddWatchFragment() : Fragment() {

    lateinit var binding: AddWatchBinding
    lateinit var auth: FirebaseAuth

    var db : AppDataBase? = null
    var watchList = mutableListOf<WatchEntity>()

    // 1. Context를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. Context를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = AddWatchBinding.inflate(inflater, container, false)
        auth = FirebaseAuth.getInstance()
        db = AppDataBase.getInstance(mainActivity)
        val savedWatch = db!!.watchDAO().showAll()


        if(savedWatch.isNotEmpty()) watchList.addAll(savedWatch)
        val adapter = WatchAdapter(watchList)

        binding.saveButton.setOnClickListener {
            // 이 부분 문법 확인하고 정리
            if (binding.writeBrand.text.toString().isNotEmpty() and binding.writeNameText.text.toString().isNotEmpty()
                and binding.writeCaseSizeText.text.isNotEmpty() and binding.writeLugtoLugText.text.isNotEmpty()) {

                val watch = WatchEntity(null, binding.writeBrand.text.toString(), binding.writeNameText.text.toString(), binding.writeRefNumberText.text.toString(),
                    binding.writeCaseSizeText.text.toString().toDoubleOrNull(),binding.writeLugtoLugText.text.toString().toDoubleOrNull(),
                    binding.writeThicknessText.toString().toDoubleOrNull(), auth.currentUser?.email, System.currentTimeMillis())

                db!!.watchDAO().writeWatch(watch)
                watchList.clear()
                watchList.add(watch)
            }
            adapter.notifyDataSetChanged()

            binding.writeBrand.setText("")
            binding.writeNameText.setText("")
            binding.writeRefNumberText.setText("")
            binding.writeCaseSizeText.setText("")
            binding.writeLugtoLugText.setText("")
            binding.writeLugtoLugText.setText("")
        }
        binding.watchListRecycler.adapter = adapter
        binding.watchListRecycler.layoutManager = LinearLayoutManager(mainActivity)

        return binding.root
    }
}