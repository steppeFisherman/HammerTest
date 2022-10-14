package com.example.dodotest

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dodotest.databinding.FragmentBasketBinding

class BasketFragment : BaseFragment<FragmentBasketBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentBasketBinding.inflate(inflater, container, false)
}