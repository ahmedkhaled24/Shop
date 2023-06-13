package com.hamtary.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamtary.myapplication.adapters.CategoryAdapter
import com.hamtary.myapplication.databinding.FragmentHomeBinding
import com.hamtary.myapplication.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getCategories()
        categoryData()
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        lifecycleScope.launchWhenStarted {
            launch {
                mainViewModel.categoryStatus.collect(
                    EventObserver(
                        onLoading = {
                            // binding!!.spinKit.isVisible = true
                        },
                        onSuccess = { data ->
                            //binding!!.spinKit.isVisible = false
                            Toast.makeText(requireContext(), "Size= "+data.data!!.data.size, Toast.LENGTH_SHORT).show()
                        },
                        onError = {
                            //  binding!!.spinKit.isVisible = false
                        }
                    )
                )

            }
//            launch {
//                mainViewModel.bannersStatus.collect(
//                    EventObserver(
//                        onLoading = {
//
//                        },
//                        onSuccess = {
//
//                            for (img in it.data!!) {
//                                img.image?.let { it1 -> imageList.add(it1) }
//                            }
//                            bannerAdapter.differ.submitList(it.data)
//
//                        }, onError = {
//
//                        }
//                    )
//                )
//            }

        }
    }

    private fun categoryData() {
//        categoryRv = binding!!.root.findViewById(R.id.category_rv)

        categoryAdapter = CategoryAdapter()
        binding.root.categoryRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        categoryRv.adapter = categoryAdapter
    }
}