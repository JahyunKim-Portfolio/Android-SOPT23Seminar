package com.sopt23.seminar06.network

import com.google.gson.JsonObject
import com.sopt23.seminar06.get.GetBoardListResponse
import com.sopt23.seminar06.post.PostLoginResponse
import com.sopt23.seminar06.post.PostSignupResponse
import com.sopt23.seminar06.post.PostWriteBoardResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    // Signup
    @POST("/users")
    fun postSignUpResponse(
            @Header("Content-type") content_type: String,
            @Body() body: JsonObject

    ): Call<PostSignupResponse>

    @POST("/login")
    fun postLoginResponse(
            @Header("Content-type") content_type: String,
            @Body() body: JsonObject
    ): Call<PostLoginResponse>

    @Multipart
    @POST("/contents")
    fun postWriteBoardResponse(
            @Header("Authorization") token: String,
            @Part("title") title: RequestBody,
            @Part("contents") contents: RequestBody,
            @Part photo: MultipartBody.Part?
    ):Call<PostWriteBoardResponse>

    @GET("/contents")
    fun getBoardListResponse(
            @Header("Content-Type") content_type: String,
            @Query("offset") offset: Int,
            @Query("limit") limit: Int
    ): Call<GetBoardListResponse>
}