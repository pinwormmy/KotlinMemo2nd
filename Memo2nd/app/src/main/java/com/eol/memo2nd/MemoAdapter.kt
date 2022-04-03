package com.eol.memo2nd


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eol.memo2nd.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MemoAdapter : RecyclerView.Adapter<Holder>(){

    var listData = mutableListOf<Memo>()
    var dbHelper:DBopenHelper? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding).apply {
            binding.deleteButton.setOnClickListener {

                var cursor = adapterPosition

                //강제로 null을 허용하기 위해 !! 사용
                dbHelper?.deleteMemo(listData.get(cursor))
                listData.remove(listData.get(cursor))
                notifyDataSetChanged()
            }
        }
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
        // binding.textUserId.text = memo.userId.toString() 생략해보기
        binding.textMemoContent.text = memo.memoContent
        val sdf = SimpleDateFormat("yyyy/MM/dd hh:mm")
        binding.textDateTime.text = "${sdf.format(memo.dateTime)}"
    }
}
