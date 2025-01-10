package com.example.newsapp.ui.offlineRead

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentOfflineBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OfflineFragment:Fragment(R.layout.fragment_offline){

    private lateinit var binding : FragmentOfflineBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentOfflineBinding.bind(view)

    }
}