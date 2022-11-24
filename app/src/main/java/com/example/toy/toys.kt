package com.example.toy

import android.graphics.drawable.Drawable
import android.os.Parcel
import android.os.Parcelable

data class toys(var title: String?) : Parcelable
{
    var description: String? = ""
    var price: Drawable? = null

    constructor(parcel: Parcel) : this(parcel.readString()) {
        description = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<toys> {
        override fun createFromParcel(parcel: Parcel): toys {
            return toys(parcel)
        }

        override fun newArray(size: Int): Array<toys?> {
            return arrayOfNulls(size)
        }
    }


}



