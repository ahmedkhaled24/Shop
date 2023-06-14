package com.hamtary.myapplication.ui.features.listOfItems

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hamtary.myapplication.data.model.ProductListResponseModel
import com.hamtary.myapplication.databinding.FragmentListOfItemsBinding
import com.hamtary.myapplication.utils.ConnectivityReceiver

private const val TAG = "ListOfItemsFragment"
class ListOfItemsFragment: Fragment(),
    ListOfItemsAdapter.ProductListViewHolder.OnItemClickListener,
    ConnectivityReceiver.ConnectivityReceiverListener {

    private lateinit var binding: FragmentListOfItemsBinding
    private val viewModel: ListOfItemsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListOfItemsBinding.inflate(inflater, container, false)

        requireActivity().
        registerReceiver(ConnectivityReceiver(), IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

        renderProductListData()

        return binding.root
    }


    private fun renderProductListData() {
        lifecycleScope.launchWhenCreated {
            viewModel.productListState.collect { state ->
                when(state){
                    is ListOfItemsViewModel.ProductListState.Success -> {
                        Log.d(TAG, "renderProductListData: Success")
                        Log.d(TAG, "renderProductListData: list size ${state.productListResponseModel.size}")
                        setUpProductList(state.productListResponseModel)
                    }
                    is ListOfItemsViewModel.ProductListState.Error -> {
                        Log.d(TAG, "renderProductListData: Error ${state.message}")
                    }
                    is ListOfItemsViewModel.ProductListState.Loading -> {
                        Log.d(TAG, "renderProductListData: Loading")
                    }
                    is ListOfItemsViewModel.ProductListState.Idle -> {
                        Log.d(TAG, "renderProductListData: Idle")
                        viewModel.getProductList()
                    }
                }
            }
        }
    }

    private fun setUpProductList(productList: ProductListResponseModel) {
        val adapter = ListOfItemsAdapter(this)
        adapter.submitList(productList)
        binding.productListRv.adapter = adapter
    }

    override fun onItemClick(productId: Int?) {
//        findNavController().navigate(ProductListFragmentDirections.actionProductListFragmentToProductDetailsFragment(productId.toString()))
    }

    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        showNetworkMessage(isConnected)
    }
    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }
    private fun showNetworkMessage(isConnected: Boolean) {
        if (!isConnected) {
            binding.notInternetConnectionLayout.root.visibility = View.VISIBLE
            binding.productListRv.visibility = View.GONE
        } else {
            binding.notInternetConnectionLayout.root.visibility = View.GONE
            binding.productListRv.visibility = View.VISIBLE
            if(binding.productListRv.adapter == null)
                viewModel.getProductList()

        }
    }
}