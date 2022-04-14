package com.eol.memo2nd


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eol.memo2nd.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MemoAdapter : RecyclerView.Adapter<Holder>(){

    var listData = mutableListOf<Watch>()
    var dbHelper:DBopenHelper? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val watch = listData[position]
        holder.setData(watch)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


}
class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){

    fun setData(watch: Watch){
        // binding.textwatchId.text = memo.watchId.toString()
        // binding.textss.text = memo.memoContent
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")

    }
}
