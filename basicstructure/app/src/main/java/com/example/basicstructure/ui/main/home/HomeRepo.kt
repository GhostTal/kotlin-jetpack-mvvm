package com.example.basicstructure.ui.main.home

import com.example.baselib.base.BaseRepository
import com.example.basicstructure.bean.ArticleListBean
import com.example.basicstructure.http.ApiService
import com.example.basicstructure.http.RetrofitManager

class HomeRepo : BaseRepository(){
    private var page = 0

    // 获取置顶文章
    suspend fun getTopArticles() = withIO {
        // 请求置顶
        RetrofitManager.getApiService(ApiService::class.java)
            .getTopList()
            .data()
            .let {
                // 对模型转换
                ArticleListBean.trans(it)
            }
    }


    /**
     * 获取banner
     */
    suspend fun getBanner() = withIO {
        RetrofitManager.getApiService(ApiService::class.java)
            .getBanner()
            .data()
    }


    /**
     * 请求第一页
     */
    suspend fun getArticles() = withIO {
        page = 0
        RetrofitManager.getApiService(ApiService::class.java)
            .getHomeList(page)
            .data()
            .datas?.let {
                ArticleListBean.trans(it)
            }?: mutableListOf()
    }
}