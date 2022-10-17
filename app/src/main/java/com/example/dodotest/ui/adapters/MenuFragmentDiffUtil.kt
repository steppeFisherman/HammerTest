package com.example.dodotest.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.dodotest.ui.model.DataAppCombined

class MenuFragmentDiffUtil(
    private val oldList: List<DataAppCombined>,
    private val newList: List<DataAppCombined>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size
    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition] != newList[newItemPosition] -> false
            else -> true
        }
    }
}
