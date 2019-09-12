package com.armhansa.preparefortesting.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TodoModel(var todoTitle: String, var isDone: Boolean) : Parcelable