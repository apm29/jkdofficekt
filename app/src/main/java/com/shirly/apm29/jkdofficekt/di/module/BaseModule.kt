package com.shirly.apm29.jkdofficekt.di.module

import android.app.Application
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.shirly.apm29.jkdofficekt.base.AppManager
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class BaseModule(val app: Application) {
    @Provides
    @Singleton
    fun providesAppManager(): AppManager {
        return AppManager()
    }

    @Provides
    @Singleton
    fun providesHandler(): Handler {
        return Handler(Looper.getMainLooper())
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl("http://office-api.junleizg.com.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//新的配置
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor {
            Log.d("ZPlus-http", it)
        }
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor {
                    val originRequest = it.request()
                    var request: Request = originRequest
                    /**
                     * 设置请求格式
                     */
                    val token = app.getSharedPreferences("ZPLUS", Application.MODE_PRIVATE)
                            .getString("access_token", "")
                    if (originRequest.method().equals("POST", ignoreCase = true)) {
                        val body = originRequest.body()
                        val formBody: FormBody
                        formBody = body as? FormBody ?: FormBody.Builder().build()
                        val bizBuilder = getJSONStringBuilder(formBody)

                        //构建JSon
                        val jsonBuilder = StringBuilder()
                        jsonBuilder.append("{")
                        jsonBuilder.append("\"")
                                .append("access_token")
                                .append("\"").append(":")
                                .append("\"").append(token)
                                .append("\"").append(",")
//                        jsonBuilder.append("\"").append("registration_id").append("\"").append(":").append("\"").append(registrationID).append("\"").append(",")

                        jsonBuilder.append("\"")
                                .append("biz_content")
                                .append("\"")
                                .append(":")
                                .append(bizBuilder.toString())
                        jsonBuilder.append("}")

                        val requestBody = RequestBody.create(MediaType.parse("Content-Type:application/json; charset=utf-8"), jsonBuilder.toString())
                        //重建request
                        request = originRequest.newBuilder()
                                .post(requestBody)
                                .header("Content-Type", "application/json; charset=utf-8")
                                .build()
                    }


                    return@addInterceptor it.proceed(request)
                }
                .build()
    }


    private fun getJSONStringBuilder(formBody: FormBody): StringBuilder {
        val bizBuilder = StringBuilder("{")
        for (i in 0 until formBody.size()) {
            val name = formBody.name(i)
            val value = formBody.value(i)
            if (value != null)
                bizBuilder
                        .append("\"").append(name).append("\"")
                        .append(":")
                        .append("\"").append(value).append("\"")
                        .append(",")
            if (i == formBody.size() - 1) bizBuilder.deleteCharAt(bizBuilder.lastIndexOf(","))
        }
        bizBuilder.append("}")
        //只有一个biz_content的时候直接返回原String
        return if (formBody.size() == 1 && formBody.name(0).equals("biz_content", ignoreCase = true)) {
            StringBuilder(formBody.value(0))
        } else bizBuilder
    }
}