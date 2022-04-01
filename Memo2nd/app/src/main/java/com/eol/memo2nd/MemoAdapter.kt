package com.eol.memo2nd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eol.memo2nd.databinding.ItemRecyclerBinding

class MemoAdapter : RecyclerView.Adapter<Holder>(){

    var listData = mutableListOf<Memo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData[position]
        holder.setData(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}
class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){

    fun setData(memo: Memo){
        binding.textView.text = memo.name
    }
}
