package com.eol.memo2nd

import android.content.ContentValues.TAG
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.eol.memo2nd.databinding.SearchTestBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class SearchTestFragment : Fragment(){
    // ViewBinding
    private lateinit var binding : SearchTestBinding

    var db : AppDataBase? = null

    var watchList = mutableListOf<WatchEntity>()

    // 1. 컨텍스트를 할당할 변수를 프로퍼티로 선언(어디서든 사용할 수 있게)
    private lateinit var mainActivity: MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // 2. 컨텍스트를 액티비티로 형변환해서 할당
        mainActivity = context as MainActivity
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        super.onCreate(savedInstanceState)

        binding = SearchTestBinding.inflate(layoutInflater)

        db = AppDataBase.getInstance(mainActivity)

        val savedWatch = db!!.watchDAO().showAll()
        if(savedWatch.isNotEmpty()) watchList.addAll(savedWatch)
        val adapter = WatchAdapter(watchList)

        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        binding.searchBarTest.addTextChangedListener(object : TextWatcher {


            // 반복되는 문구 함수로 빼기
            override fun afterTextChanged(p0: Editable?) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO().showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO().showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if(p0.toString() == "" || p0.toString() == null){
                    watchList.clear()
                }else{
                    val searchWatch = db!!.watchDAO().showSearch(p0.toString())
                    watchList.clear()
                    watchList.addAll(searchWatch)
                    adapter.notifyDataSetChanged()
                }
            }
        })
        binding.searchResult.adapter = adapter
        binding.searchResult.layoutManager = LinearLayoutManager(mainActivity)

        return binding.root
    }
}