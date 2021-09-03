package com.idn.smart.tiyas.dicodingsubmission.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScarlettModel(
    var name : String,
    var price : String,
    var photo : String,
    var description : String,
) : Parcelable