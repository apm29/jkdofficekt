package com.example.dingzhu.zuoplus.model.bean

data class CategoryContent(val hotList: ArrayList<ContListItem>?,
                           val contList: ArrayList<ContListItem>?,
                           val areaList: ArrayList<AreaListItem>?,
                           val resultCode: String = "",
                           val nextUrl: String = "",
                           val systemTime: String = "",
                           val categoryInfo: CategoryInfo,
                           val resultMsg: String = "",
                           val reqId: String = "")