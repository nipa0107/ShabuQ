package com.example.finalproject

import android.os.Parcel
import android.os.Parcelable

class BookingParcelable (val id_booking: Int ,val booking_seats: Int,val booking_status: String,val booking_name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),



    ) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id_booking)
        parcel.writeInt(booking_seats)
        parcel.writeString(booking_status)
        parcel.writeString(booking_name)


    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserParcelable> {
        override fun createFromParcel(parcel: Parcel): UserParcelable {
            return UserParcelable(parcel)
        }

        override fun newArray(size: Int): Array<UserParcelable?> {
            return arrayOfNulls(size)
        }
    }
}