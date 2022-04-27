package com.eol.memo2nd


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eol.memo2nd.databinding.ItemRecyclerBinding
import com.eol.watch2nd.DBopenHelper
import java.text.SimpleDateFormat

class WatchAdapter(var listData : List<WatchEntity>) : RecyclerView.Adapter<WatchAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        binding.collectionNameView.setOnClickListener(){
            binding.refNumView.visibility = View.VISIBLE
            binding.refNumView.bringToFront()
        }

        binding.refNumView.setOnClickListener(){
            binding.refNumView.visibility = View.GONE
        }

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val watch:WatchEntity = listData.get(position)
        holder.setData(watch)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class Holder(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root){

        fun setData(watch: WatchEntity){

            binding.watchIdView.text = watch.watchId.toString()
            binding.brandView.text = watch.brand
            binding.collectionNameView.text = watch.collectionName
            binding.refNumView.text = watch.refNumber
            binding.caseSizeView.text = watch.caseSize.toString()
            binding.writeLugtoLugView.text = watch.lugTolugSize.toString()
            val sdf = SimpleDateFormat("yyyy/MM/dd")
            binding.dateTimeView.text = "${sdf.format(watch.dateTime)}"

        }
    }
}


