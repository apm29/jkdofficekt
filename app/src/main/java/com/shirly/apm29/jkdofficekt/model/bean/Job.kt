package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.shirly.apm29.jkdofficekt.BR
class Job:BaseObservable{
    @Bindable
     var allow_field: String = ""
    set(value) {
        field =value
        notifyPropertyChanged(BR.allow_field)
    }
    @Bindable
     var company_name: String = ""
        set(value) {
            field =value
            notifyPropertyChanged(BR.company_name)
        }
    @Bindable
     var position_level: String = ""
        set(value) {
            field =value
            notifyPropertyChanged(BR.position_level)
        }
    @Bindable
     var id: Int = 0
        set(value) {
            field =value
            println("job id set $field")
            notifyPropertyChanged(BR.id)
        }
        get() {
            println("job id get $field")
            return field
        }
    @Bindable
     var department: String = ""
        set(value) {
            field =value
            notifyPropertyChanged(BR.department)
        }

    private val staffingMap:Map<Int,String> = mapOf(
            Pair(0,"事业"),
            Pair(1,"企业"),
            Pair(2,"公务员")
    )
    /**
     *  '编制: 0 事业 1 企业 2 公务员',
     */
     var staffing: Int = 0

    @Bindable
    fun getStaffingString(): String {
        return staffingMap[staffing]?:""
    }

    fun setStaffingString(str: String) {
       staffingMap.forEach {
           if (it.value==str)
               staffing = it.key
       }
        notifyPropertyChanged(BR.staffingString)

    }

    override fun toString(): String {
        return "Job(allow_field='$allow_field', company_name='$company_name', position_level='$position_level', id=$id, department='$department', staffingMap=$staffingMap, staffing=$staffing)"
    }

    constructor()

    constructor(allow_field: String, company_name: String, position_level: String, id: Int, department: String, staffing: Int){
        this.allow_field = allow_field
        this.company_name = company_name
        this.position_level = position_level
        this.id = id
        this.department = department
        this.staffing = staffing
    }



}
