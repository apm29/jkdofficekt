package com.example.dingzhu.zuoplus.model.bean

data class Category(val resultCode: String = "",
                    val categoryList: List<CategoryListItem>?,
                    val systemTime: String = "",
                    val resultMsg: String = "",
                    val reqId: String = "")