package com.bellodev.recyclerviewapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ryannf.resepmakanan.ResepMakanan
import com.ryannf.resepmakanan.ViewHolder

class MyAdapter (private val data:ArrayList<ResepMakanan>): RecyclerView.Adapter<ViewHolder>(){

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }
}