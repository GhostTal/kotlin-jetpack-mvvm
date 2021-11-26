package com.example.basicstructure.http

import com.example.basicstructure.bean.ArticleBean
import com.example.basicstructure.ui.main.home.BannerBean
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/article/top/json")
    suspend fun getTopArticleList(): ApiResponse<MutableList<ArticleBean.DatasBean>>


    /**
     * 获取首页置顶文章数据
     */
    @GET("/article/top/json")
    suspend fun getTopList(): ApiResponse<MutableList<ArticleBean.DatasBean>>


    /**
     * banner
     */
    @GET("/banner/json")
    suspend fun getBanner(): ApiResponse<MutableList<BannerBean>>



    /**
     * 获取首页文章数据
     */
    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") pageNo: Int): ApiResponse<ArticleBean>
}