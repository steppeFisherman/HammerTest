package com.example.dodotest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dodotest.databinding.ItemRawBinding
import com.example.dodotest.ui.model.DataAppCombined
import com.example.dodotest.utils.LoadImage

class MenuAdapter(private val loadImage: LoadImage) :
    RecyclerView.Adapter<MenuAdapter.MainViewHolder>() {

    private var mList = emptyList<DataAppCombined>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(
            ItemRawBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val price = "от ${mList[position].discount_price} р"

        holder.binding.title.text = mList[position].title
        holder.binding.description.text = mList[position].description
        holder.binding.price.text = price
        loadImage.load(holder.binding.mainImg, mList[position].picture)
    }

    override fun getItemCount(): Int = mList.size

    class MainViewHolder(val binding: ItemRawBinding) : RecyclerView.ViewHolder(binding.root)

    fun setData(newList: List<DataAppCombined>) {
        val diffUtil = MenuFragmentDiffUtil(mList, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        mList = newList
        diffResult.dispatchUpdatesTo(this)
    }
}