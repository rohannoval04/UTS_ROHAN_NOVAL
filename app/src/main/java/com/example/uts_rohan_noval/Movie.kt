package com.example.uts_rohan_noval

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    var imageMovie: Int,
    var titleMovie: String,
    var descMovie: String
) : Parcelable