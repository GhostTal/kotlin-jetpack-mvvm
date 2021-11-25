package com.example.basicstructure.http

import com.example.basicstructure.bean.ArticleBean
import retrofit2.http.GET

interface ApiService {
    @GET("/article/top/json")
    suspend fun getTopArticleList(): ApiResponse<MutableList<ArticleBean.DatasBean>>
}