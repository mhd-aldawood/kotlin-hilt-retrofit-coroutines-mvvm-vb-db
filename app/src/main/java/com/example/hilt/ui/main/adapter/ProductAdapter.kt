package com.example.hilt.ui.main.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt.data.model.responde.Product
import com.example.hilt.data.model.reuqest.User
import com.example.hilt.databinding.ItemLayoutBinding
import com.example.hilt.databinding.ProductLayoutBinding
import com.mindorks.framework.mvvm.ui.main.adapter.MainAdapter
import kotlinx.android.synthetic.main.product_layout.view.*
import com.bumptech.glide.Glide
import com.example.hilt.ui.main.interfaces.OnItemClickListener

class ProductAdapter(private val products: ArrayList<Product>,val onItemClickListener: OnItemClickListener): RecyclerView.Adapter<ProductAdapter.DataViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        ProductLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =holder.bind(products[position],onItemClickListener)

    override fun getItemCount(): Int =products.size

    fun addData(list: List<Product>) {
        products.addAll(list)
    }
    class DataViewHolder(itemView: ProductLayoutBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(product: Product,itemClickListener: OnItemClickListener) {

            Glide.with(itemView.image_view.context)
                .load(product.image)
                .into(itemView.image_view)

            itemView.price.text=product.price.toString()+"Aed"
            itemView.rank.rating= (product.rating?.rate!!?.toFloat())
            itemView.rank.progressDrawable.setColorFilter(Color.parseColor("#FFE072"),
                PorterDuff.Mode.SRC_ATOP)
            itemView.title.text=product.title.toString()
            itemView.description.text=product.description.toString()
            itemView.setOnClickListener(View.OnClickListener { itemClickListener.onClick(product) })
        }
    }
}