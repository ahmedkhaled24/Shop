package com.hamtary.myapplication.ui.features.listOfItems

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.hamtary.myapplication.BR
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hamtary.myapplication.data.model.ProductListResponseModel
import com.hamtary.myapplication.databinding.ProductListItemBinding

private const val TAG = "ListOfItemsAdapter"
class ListOfItemsAdapter(private val onItemClickListener: ProductListViewHolder.OnItemClickListener) :
    ListAdapter<ProductListResponseModel.ProductListResponseModelItem,
            ListOfItemsAdapter.ProductListViewHolder>(ProductsModelDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }

    class ProductsModelDiffCallback
        : DiffUtil.ItemCallback<ProductListResponseModel.ProductListResponseModelItem>() {

        override fun areItemsTheSame(
            oldItem: ProductListResponseModel.ProductListResponseModelItem,
            newItem: ProductListResponseModel.ProductListResponseModelItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductListResponseModel.ProductListResponseModelItem,
            newItem: ProductListResponseModel.ProductListResponseModelItem)
        : Boolean {
            return oldItem == newItem
        }

    }

    override fun onViewRecycled(holder: ProductListViewHolder) {
        super.onViewRecycled(holder)
        holder.recycle()
    }

    class ProductListViewHolder(private val binding: ProductListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun create(parent: ViewGroup): ProductListViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ProductListItemBinding.inflate(layoutInflater, parent, false)
                return ProductListViewHolder(binding)
            }
        }

        fun bind(obj: ProductListResponseModel.ProductListResponseModelItem,
                 onItemClickListener: OnItemClickListener) {

            binding.setVariable(BR.model, obj)

            binding.executePendingBindings()

            itemView.setOnClickListener {
                onItemClickListener.onItemClick(obj.id)
            }

            binding.likeImgHome.setOnClickListener {
                binding.likeImgHome.visibility = View.GONE
                binding.likedImgHome.visibility = View.VISIBLE
                Toast.makeText(it.context,"Product liked", Toast.LENGTH_LONG).show()
            }

            binding.likedImgHome.setOnClickListener {
                binding.likeImgHome.visibility = View.VISIBLE
                binding.likedImgHome.visibility = View.GONE
                Toast.makeText(it.context,"Product unliked", Toast.LENGTH_LONG).show()
            }

        }

        fun recycle() {
            itemView.setOnClickListener(null)
        }

        interface OnItemClickListener {
            fun onItemClick(productId: Int?)
        }
    }

}