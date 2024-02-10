package com.example.hotels.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.common.base.BaseFragment
import com.example.common.base.BaseViewModel
import com.example.hotels.adapter.HotelsListAdapter
import com.example.hotels.databinding.FragmentHotelsBinding
import com.example.hotels.viewmodels.HotelsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HotelsFragment : BaseFragment<FragmentHotelsBinding>(FragmentHotelsBinding::inflate) {

    lateinit var hotelsAdapter: HotelsListAdapter

    private val viewModel: HotelsViewModel by viewModels()


    override fun mViewModel(): BaseViewModel {
        return viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()

        lifecycleScope.launch {
            viewModel.getFlights()
            viewModel.hotels.collectLatest {
                hotelsAdapter.submitList(it)
            }
        }

    }

    private fun setUpRecyclerView() {
        hotelsAdapter = HotelsListAdapter(onClick = {})
        binding.hotelsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = hotelsAdapter
        }

    }
}

