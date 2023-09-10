package com.example.budget_tracker.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.budget_tracker.Db.Tags
import com.example.budget_tracker.R
import com.example.budget_tracker.databinding.ListDrawerlayoutBinding

class List_adapter2: RecyclerView.Adapter<MyViewHolder>() {
    private val tagList=ArrayList<Tags>()
    fun setList(data:List<Tags>){
        tagList.clear()
        tagList.addAll(data)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        val binding: ListDrawerlayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.list_drawerlayout,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tagList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tagList[position])
    }

}

class MyViewHolder(val binding:ListDrawerlayoutBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(data:Tags){
        binding.textView3.text=data.name
    }

}