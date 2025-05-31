package com.example.adminshabu

import android.os.Parcel
import android.os.Parcelable

class AdminParcelable (val id_admin: Int ,val admin_name: String, val admin_email: String, val admin_password: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_admin)
        parcel.writeString(admin_name)
        parcel.writeString(admin_email)
        parcel.writeString(admin_password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AdminParcelable> {
        override fun createFromParcel(parcel: Parcel):AdminParcelable {
            return AdminParcelable(parcel)
        }

        override fun newArray(size: Int): Array<AdminParcelable?> {
            return arrayOfNulls(size)
        }
    }
}