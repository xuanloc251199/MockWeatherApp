package com.teamdcls.mockweather.reponsitory.api.cityrepository

import android.util.Log
import com.google.gson.GsonBuilder
import com.teamdcls.mockweather.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    private const val TIME_OUT: Long = 120

    private val gson = GsonBuilder().setLenient().create()
    private val logging: HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .build()
//        .addInterceptor { chain ->
//            val resp = chain.proceed(chain.request())
//            // Deal with the response code
//            if (resp.code == 200) {
//                try {
//                    val myJson = resp.body
////                        resp.peekBody(2048).string() // peekBody() will not close the response
//                    println(myJson)
//                } catch (e: Exception) {
//                    Log.d("error", "Error parse json from intercept..............")
//                }
//            } else {
//                Log.d("error", resp.code.toString())
//            }
//            resp
//        }.build()

    val retrofit: RetrofitInterface by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .build().create(RetrofitInterface::class.java)
    }

}