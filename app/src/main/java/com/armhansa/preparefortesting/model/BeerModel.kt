package com.armhansa.preparefortesting.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BeerModel(
    @SerializedName("name")
    var name: String?,

    @SerializedName("description")
    var description: String?,

    @SerializedName("abv")
    var abv: Double?,

    @SerializedName("image_url")
    var imageUrl: String?
) : Parcelable