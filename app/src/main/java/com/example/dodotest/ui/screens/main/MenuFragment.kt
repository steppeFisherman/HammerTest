package com.example.dodotest.ui.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.dodotest.R
import com.example.dodotest.databinding.FragmentMenuBinding
import com.example.dodotest.ui.adapters.MenuAdapter
import com.example.dodotest.ui.model.MapCombined
import com.example.dodotest.ui.screens.BaseFragment
import com.example.dodotest.utils.LoadImage
import com.example.dodotest.utils.showSnackLong
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>() {

    private val combine = MapCombined.Base()
    private val vm by viewModels<MenuFragmentViewModel>()

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentMenuBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = MenuAdapter(LoadImage.Base())
        mBinding.rvMain.adapter = adapter

        vm.allItems.observe(viewLifecycleOwner) {

            val dataAppCombined = combine.combine(it)
            val empty = dataAppCombined.isNullOrEmpty()
            mBinding.progressBar.visibility = if (empty) View.VISIBLE else {
                adapter.setData(dataAppCombined)
                View.INVISIBLE
            }
        }

        vm.error.observe(viewLifecycleOwner) {
            when (it.ordinal) {
                0 -> view.showSnackLong(R.string.no_connection_message)
                1 -> view.showSnackLong(R.string.null_pointer_exception)
                2 -> view.showSnackLong(R.string.something_went_wrong)
                3 -> view.showSnackLong(R.string.service_unavailable_message)
            }
        }
    }
}