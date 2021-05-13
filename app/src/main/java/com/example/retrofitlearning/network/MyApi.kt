package com.example.retrofitlearning.network

import com.example.retrofitlearning.models.*
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MyApi {


    @GET("top-headlines") //country=us&category=business&apiKey=c75ad35f47db41f09fcb0f0cc98269fc)
    fun getPost(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Observable<NewsResponse>

    //@POST("posts")
    //fun makePost(@Body postGenerator: PostGenerator): Call<PostResponseItem>


    companion object{
        operator fun invoke(): MyApi{
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}