package com.example.hilt.ui.main.view

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.hilt.R
import com.example.hilt.data.model.responde.Product
import com.example.hilt.databinding.ActivityDetailedBinding
import kotlinx.android.synthetic.main.product_layout.view.*


class DetailedActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailedBinding
    lateinit var product:Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_detailed)
        binding.lifecycleOwner=this
        product = intent.getParcelableExtra<Product>("obj")!!

        setupUI()

    }

    private fun setupUI() {
        binding.price.text=product.price.toString()+"Aed"
        binding.ratingBar.rating=(product.rating?.rate!!?.toFloat())
        binding.ratingBar.progressDrawable.setColorFilter(
            Color.parseColor("#FFE072"),
            PorterDuff.Mode.SRC_ATOP)
        binding.titleDescriptor.text=product.title.toString()
        binding.descriptor.text=product.description.toString()
        binding.review.text= product.rating!!.count.toString()
        binding.rbValue.text= product.rating!!.rate.toString()
        Glide.with(binding.imageView.context)
            .load(product.image)
            .into(binding.imageView)
    }
}