package com.example.finalproject

import android.os.Parcel
import android.os.Parcelable

class TableTypeParcelable (val id_type: Int ,val type_name: String, val id_admin: Int) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
    //    parcel.readInt(),
        parcel.readInt(),

    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_type)
        parcel.writeString(type_name)
   //     parcel.writeInt(booking_seats)
        parcel.writeInt(id_admin)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TableTypeParcelable> {
        override fun createFromParcel(parcel: Parcel): TableTypeParcelable {
            return TableTypeParcelable(parcel)
        }

        override fun newArray(size: Int): Array<TableTypeParcelable?> {
            return arrayOfNulls(size)
        }
    }
}