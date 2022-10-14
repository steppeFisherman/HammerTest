package com.example.dodotest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dodotest.databinding.ItemRawBinding

class Adapter : RecyclerView.Adapter<Adapter.MainViewHolder>() {

    val list = listOf<Item>(
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
        Item("dfggdfgfgfd"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            ItemRawBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.binding.rvMainTitle.text = list[position].name
    }

    override fun getItemCount(): Int = list.size

    class MainViewHolder(val binding: ItemRawBinding) : RecyclerView.ViewHolder(binding.root)
}