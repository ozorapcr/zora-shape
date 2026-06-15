package com.example.zora_shape.Database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zora_shape.databinding.ItemHistoryBinding
import java.text.SimpleDateFormat
import java.util.*

class HistoryAdapter(private var historyList: List<CalculationHistory>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(val binding: ItemHistoryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyList[position]
        holder.binding.tvHistoryTitle.text = item.title
        holder.binding.tvHistoryInput.text = item.input
        holder.binding.tvHistoryResult.text = item.result
        
        val sdf = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        holder.binding.tvHistoryDate.text = sdf.format(Date(item.date))
    }

    override fun getItemCount(): Int = historyList.size

    fun setData(newList: List<CalculationHistory>) {
        historyList = newList
        notifyDataSetChanged()
    }
}