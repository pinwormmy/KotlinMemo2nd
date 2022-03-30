package com.eol.sqlitetest

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.Holder>() {
    var listData = ArrayList<Memo>()
    var helper:SqliteHelper? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler,parent,false)
        return Holder(view).apply {

            //삭제버튼 클릭시 이벤트
            itemView.btn_del.setOnClickListener {

                var cursor = adapterPosition

                //강제로 null을 허용하기 위해 !! 사용
                helper?.deleteMemo(listData.get(cursor))
                listData.remove(listData.get(cursor))
                notifyDataSetChanged()
            }
        }

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo:Memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size

    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setMemo(memo:Memo){
            itemView.textuserId.text = memo.userId.toString()
            itemView.textmemoContent.text = memo.memoContent.toString()
            val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
            itemView.textSubmitTime.text = "${sdf.format(memo.submitTime)}"

        }

    }

}