package com.example.hilt.ui.main.interfaces

import com.example.hilt.data.model.responde.Product

interface OnItemClickListener {
    fun onClick(product : Product)
}