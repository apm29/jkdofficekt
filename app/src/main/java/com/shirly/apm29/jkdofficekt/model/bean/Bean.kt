package com.shirly.apm29.jkdofficekt.model.bean

import com.google.gson.annotations.SerializedName

/**
 * {
"code": 200,
"msg": "成功",
"data": {
"0102": "中国工商银行",
"0103": "中国农业银行",
...
}
}
 */

data class Bean<out T>(@SerializedName("msg")
                       val msg: String = "",
                       @SerializedName("code")
                       val code: Int = 0,
                       @SerializedName("data")
                       val data: T?) {
    fun isSuccess(): Boolean {
        return code == 200
    }
}

