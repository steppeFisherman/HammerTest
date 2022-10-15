package com.example.dodotest.ui.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dodotest.databinding.FragmentBasketBinding
import com.example.dodotest.ui.screens.BaseFragment

class BasketFragment : BaseFragment<FragmentBasketBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentBasketBinding.inflate(inflater, container, false)
}