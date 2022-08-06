package com.example.recyclerview_update_3.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_update_3.R
import com.example.recyclerview_update_3.databinding.ListItemBinding

class ItemAdapter(val clickListener : ItemListener):
    ListAdapter<String, ItemAdapter.ItemViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }

    class ItemViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item:String, clickListener: ItemListener){
            binding.item=item
            binding.holder=this
            binding.clickListener=clickListener

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val LayoutInflater =LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(LayoutInflater,parent,false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, clickListener)
    }
}

class ItemListener(val clickItem: (pos:Int) -> Unit){
    fun onClick(pos: Int) = clickItem(pos)
}