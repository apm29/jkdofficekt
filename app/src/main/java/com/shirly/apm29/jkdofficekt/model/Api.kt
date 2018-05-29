package com.example.dingzhu.zuoplus.model

import com.example.dingzhu.zuoplus.model.bean.Bean
import com.shirly.apm29.jkdofficekt.model.bean.Category
import com.example.dingzhu.zuoplus.model.bean.CategoryContent
import com.example.dingzhu.zuoplus.model.bean.ContentDetail
import com.shirly.apm29.jkdofficekt.model.bean.InitData
import io.reactivex.Observable
import retrofit2.http.*

interface Api {

    @GET(" /clt/jsp/v2/getCategorys.jsp")
    fun fetchData(): Observable<Category>

    @GET("/clt/jsp/v2/getCategoryConts.jsp")
    fun categoryContent(@Query("hotPageidx")page: Int, @Query("categoryId")categoryId: Int): Observable<CategoryContent>

    @GET("/clt/jsp/v2/content.jsp")
    fun contentDetail(@Query("contId")contId: Int): Observable<ContentDetail>

    @POST("/v1/user/profile")
    fun profile(): Observable<Bean<InitData>>

    @FormUrlEncoded
    @POST(value = "/user/login")
    fun login(@Field("username")username: String,@Field("pwd") pwd: String): Observable<Bean<String>>
}
