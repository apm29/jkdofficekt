package com.shirly.apm29.jkdofficekt.model.bean

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.google.gson.annotations.SerializedName


data class Profile(
    @Bindable
    @SerializedName("id")
    var id: String?,
  //23
    @Bindable
    @SerializedName("real_name")
    var real_name: String?,
  //姓名啊松
    @Bindable
    @SerializedName("marital_status")
    var marital_status: String?,
  //0
    @Bindable
    @SerializedName("repayment_type")
    var repayment_type: String?,
  //0
    @Bindable
    @SerializedName("couple_real_name")
    var coupleRealName: String?,
  //配偶姓名
    @Bindable
    @SerializedName("credit_account")
    var credit_account: String?,
  //asdfasf
    @Bindable
    @SerializedName("credit_account_password")
    var credit_account_password: String?,
  //asfdadsf
    @Bindable
    @SerializedName("credit_account_code")
    var credit_account_code: String?,
  //123123
    @Bindable
    @SerializedName("foundation_account")
    var foundation_account: String?,
  //123123
    @Bindable
    @SerializedName("couple_id_card_no")
    var couple_id_card_no: String?,
  //340823198901017515
    @Bindable
    @SerializedName("year_income")
    var year_income: String?,
  //0.00
    @Bindable
    @SerializedName("foundation_account_password")
    var foundation_account_password: String?,
  //12312312
    @Bindable
    @SerializedName("id_card_no")
    var id_card_no: String?,
  //340823198901017515
    @Bindable
    @SerializedName("term")
    var term: String?,
  //10
    @Bindable
    @SerializedName("foundation_month_amount")
    var foundation_month_amount: String?,
  //0.00
    @Bindable
    @SerializedName("allow_field")
    var allow_field: String?,
  //real_name,couple_real_name
    @Bindable
    @SerializedName("status")
    var status: String?,
  //4
    @Bindable
    @SerializedName("gender")
    var gender: String?
  //1
):BaseObservable(){
    @Bindable
    var genderString:String = ""
        get() {
            return gender?:""
        }

    @Bindable
    var maritalString:String = ""
        get() {
            return marital_status?:""
        }
    @Bindable
    var repaymentTypeString:String = ""
        get() {
            return repayment_type?:""
        }
}