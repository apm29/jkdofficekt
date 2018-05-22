package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable

class House:BaseObservable{
    
    public var owner: String = ""

    public var area: Double = 0.0

    public var allow_field: String = ""

    public var address: String = ""

    public var mortgage_amount: Double = 0.0

    public var mortgage_creditor: String = ""

    public var id: Int = 0

    public var is_mortgage: Int = 0

    constructor() 

    constructor(owner: String, area: Double, allow_field: String, address: String, mortgage_amount: Double, mortgage_creditor: String, id: Int, is_mortgage: Int){
        this.owner = owner
        this.area = area
        this.allow_field = allow_field
        this.address = address
        this.mortgage_amount = mortgage_amount
        this.mortgage_creditor = mortgage_creditor
        this.id = id
        this.is_mortgage = is_mortgage
    }

}
