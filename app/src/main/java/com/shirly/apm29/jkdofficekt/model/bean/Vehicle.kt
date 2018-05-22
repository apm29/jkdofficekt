package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.shirly.apm29.jkdofficekt.BR
class Vehicle : BaseObservable {

    @Bindable
    var allow_field: String = ""

    @Bindable
    var license: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.license)
        }

    @Bindable
    var colour: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.colour)
        }

    @Bindable
    var id: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var brand: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.brand)
        }

    constructor()

    constructor(allow_field: String, license: String, colour: String, id: Int, brand: String) {
        this.allow_field = allow_field
        this.license = license
        this.colour = colour
        this.id = id
        this.brand = brand
    }

}
