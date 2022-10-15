package com.example.dodotest.ui.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dodotest.databinding.FragmentProfileBinding
import com.example.dodotest.ui.screens.BaseFragment

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentProfileBinding.inflate(inflater, container, false)
}