package com.example.aptea.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.aptea.R
import com.example.aptea.data.model.ItemsData
import com.example.aptea.databinding.ItemsRowBinding
import kotlinx.android.synthetic.main.items_row.view.*


class ItemsAdapter(val context: Context?,
                       val clickListener: ItemsClickListener
) : RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    var itemsList: List<ItemsData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding: ItemsRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.items_row, parent, false
        )
        return ItemsViewHolder(viewBinding)
    }


    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun setItems(items: List<ItemsData>) {
        this.itemsList = items
        notifyDataSetChanged()
    }

    inner class ItemsViewHolder(private val viewBinding: ItemsRowBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {

        fun onBind(position: Int) {
            val row = itemsList[position]
            viewBinding.items = row
            viewBinding.itemClickInterface = clickListener
            // Load images using Glide library
            Glide.with(itemView.context)
                .load(GlideUrl(
                    row.url, LazyHeaders.Builder()
                        .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 11) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.181 Mobile Safari/537.36")
                        .build()
                ))
                .centerCrop()
                .thumbnail()
                .into(itemView.item_imageView)


        }
    }

}