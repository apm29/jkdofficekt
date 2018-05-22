package com.example.dingzhu.zuoplus.model

import com.example.dingzhu.zuoplus.model.bean.Bean
import com.example.dingzhu.zuoplus.model.bean.Category
import com.example.dingzhu.zuoplus.model.bean.CategoryContent
import com.example.dingzhu.zuoplus.model.bean.ContentDetail
import com.shirly.apm29.jkdofficekt.model.bean.InitData
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {


    @GET(" /clt/jsp/v2/getCategorys.jsp")
    fun fetchData(): Observable<Category>

    @GET("/clt/jsp/v2/getCategoryConts.jsp")
    fun categoryContent(@Query("hotPageidx")page: Int, @Query("categoryId")categoryId: Int): Observable<CategoryContent>

    @GET("/clt/jsp/v2/content.jsp")
    fun contentDetail(@Query("contId")contId: Int): Observable<ContentDetail>

    @POST("/v1/user/profile")
    fun profile(): Observable<Bean<InitData>>
}
