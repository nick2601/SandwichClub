package com.nikhil.sandwichclubproject.data.model

import com.google.gson.annotations.SerializedName
import android.os.Parcel
import android.os.Parcelable

data class Sandwich(
    @SerializedName("name") val name: Name,
    @SerializedName("placeOfOrigin") val placeOfOrigin: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String,
    @SerializedName("ingredients") val ingredients: List<String>
)


data class Name(
    @SerializedName("mainName") val mainName: String,
    @SerializedName("alsoKnownAs") val alsoKnownAs: List<String>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.createStringArrayList()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(mainName)
        parcel.writeStringList(alsoKnownAs)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Name> {
        override fun createFromParcel(parcel: Parcel): Name {
            return Name(parcel)
        }

        override fun newArray(size: Int): Array<Name?> {
            return arrayOfNulls(size)
        }
    }
}