package com.devrachit.swiggy_xml_imdb.presentation.list_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devrachit.swiggy_xml_imdb.data.remote.dto.Title
import com.devrachit.swiggy_xml_imdb.databinding.ItemLayoutBinding
import com.devrachit.swiggy_xml_imdb.domain.models.SearchResult

class ListAdapter(
    private val items: SearchResult,
    private val onClick: (Title) -> Unit
) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Title) {
            binding.tv1.text = item.toString()
            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.titles.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(items.titles[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListViewHolder(binding)
    }
}