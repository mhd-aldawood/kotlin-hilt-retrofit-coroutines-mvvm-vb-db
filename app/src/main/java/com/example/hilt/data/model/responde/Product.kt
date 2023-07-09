package com.example.hilt.data.model.responde

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json
import java.io.Serializable

data class Product(@Json(name ="id"          ) var id          : Int?    = null,
                   @Json(name ="title"       ) var title       : String? = null,
                   @Json(name ="price"       ) var price       : Double? = null,
                   @Json(name ="description" ) var description : String? = null,
                   @Json(name ="category"    ) var category    : String? = null,
                   @Json(name ="image"       ) var image       : String? = null,
                   @Json(name ="rating"      ) var rating      : Rating? = null):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() ?: "",
        parcel.readDouble(),
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readParcelable(Rating::class.java.classLoader) ?: Rating(0.0, 0)
    )

    override fun describeContents(): Int =0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        id?.let { dest.writeInt(it) }
        dest.writeString(title)
        price?.let { dest.writeDouble(it) }
        dest.writeString(description)
        dest.writeString(category)
        dest.writeString(image)
        dest.writeParcelable(rating, flags)    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
