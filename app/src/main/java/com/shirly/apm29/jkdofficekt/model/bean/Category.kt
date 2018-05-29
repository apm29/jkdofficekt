package com.shirly.apm29.jkdofficekt.model.bean

import com.example.dingzhu.zuoplus.model.bean.CategoryListItem

data class Category(val resultCode: String = "",
                    val categoryList: List<CategoryListItem>?,
                    val systemTime: String = "",
                    val resultMsg: String = "",
                    val reqId: String = "")