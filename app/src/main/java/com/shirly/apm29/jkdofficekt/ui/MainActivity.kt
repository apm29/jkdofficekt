package com.shirly.apm29.jkdofficekt.ui

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.google.gson.Gson
import com.shirly.apm29.jkdofficekt.R
import com.shirly.apm29.jkdofficekt.databinding.ActivityApplicantInfoBinding
import com.shirly.apm29.jkdofficekt.model.bean.Application


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //DataBindingUtil.setContentView<ViewDataBinding>(this,R.layout.activity_applicant_info)
        val applicantInfoBinding = DataBindingUtil.setContentView<ActivityApplicantInfoBinding>(this, R.layout.activity_applicant_info)

        val str = "{\n" +
                "        \"application_id\": \"23\",\n" +
                "        \"house\": [\n" +
                "            {\n" +
                "                \"allow_field\": \"owner,address\",\n" +
                "                \"owner\": \"阿斯扥\",\n" +
                "                \"area\": \"120.00\",\n" +
                "                \"id\": \"16\",\n" +
                "                \"address\": \"地址地址地址必须是汉子\",\n" +
                "                \"is_mortgage\": \"0\",\n" +
                "                \"mortgage_creditor\": \"宋丹丹\",\n" +
                "                \"mortgage_amount\": \"0.00\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"job\": {\n" +
                "            \"allow_field\": \"department\",\n" +
                "            \"id\": \"16\",\n" +
                "            \"company_name\": \"阿发森阿斯扥阿斯扥啊\",\n" +
                "            \"staffing\": \"0\",\n" +
                "            \"department\": \"送来\",\n" +
                "            \"position_level\": \"最坎壈\"\n" +
                "        },\n" +
                "        \"vehicle\": [\n" +
                "            {\n" +
                "                \"allow_field\": \"model,purchase_date\",\n" +
                "                \"id\": \"14\",\n" +
                "                \"license\": \"safasfa\",\n" +
                "                \"colour\": \"红\",\n" +
                "                \"brand\": \"宝马\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"profile\": {\n" +
                "            \"id\": \"23\",\n" +
                "            \"real_name\": \"姓名啊松\",\n" +
                "            \"marital_status\": \"0\",\n" +
                "            \"repayment_type\": \"0\",\n" +
                "            \"couple_real_name\": \"配偶姓名\",\n" +
                "            \"credit_account\": \"asdfasf\",\n" +
                "            \"credit_account_password\": \"asfdadsf\",\n" +
                "            \"credit_account_code\": \"123123\",\n" +
                "            \"foundation_account\": \"123123\",\n" +
                "            \"couple_id_card_no\": \"340823198901017515\",\n" +
                "            \"year_income\": \"0.00\",\n" +
                "            \"foundation_account_password\": \"12312312\",\n" +
                "            \"id_card_no\": \"340823198901017515\",\n" +
                "            \"term\": \"10\",\n" +
                "            \"foundation_month_amount\": \"0.00\",\n" +
                "            \"allow_field\": \"real_name,coupleRealName\",\n" +
                "            \"status\": \"4\",\n" +
                "            \"gender\": \"1\"\n" +
                "        }\n" +
                "    }"
        val application = Gson().fromJson<Application>(str, Application::class.java)
        applicantInfoBinding.bean = application
        println("before:$application")
        applicantInfoBinding.tvLoanPersonalInfoSave.setOnClickListener {
            applicantInfoBinding.bean?.profile?.id = "123"
            applicantInfoBinding.bean?.profile?.real_name = "修改一哈"
            println("after:${applicantInfoBinding.bean}")
            startActivity(Intent(this, NewPage::class.java))
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        println("config Changed  $requestedOrientation")
        super.onConfigurationChanged(newConfig)
        Toast.makeText(this, "不支持横屏", Toast.LENGTH_LONG).show()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }

}