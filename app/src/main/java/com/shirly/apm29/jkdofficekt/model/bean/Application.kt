package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.shirly.apm29.jkdofficekt.BR


class Application :BaseObservable{
    @Bindable
     var profile: Profile? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.profile)
        }
    @Bindable
     var job: Job? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.job)
        }
    @Bindable
     var applicationid: Int = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.applicationid)
        }
    @Bindable
     var house: List<House?>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.house)
        }
    @Bindable
     var vehicle: List<Vehicle?>? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.vehicle)
        }

    constructor() 

    constructor(profile: Profile, job: Job, applicationid: Int, house: List<House>, vehicle: List<Vehicle>){
        this.profile = profile
        this.job = job
        this.applicationid = applicationid
        this.house = house
        this.vehicle = vehicle
    }

    override fun toString(): String {
        return "Application(profile=$profile, job=$job, applicationid=$applicationid, house=$house, vehicle=$vehicle)"
    }


}