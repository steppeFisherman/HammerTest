package com.example.dodotest

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.dodotest.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override fun initBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentProfileBinding.inflate(inflater, container, false)
}