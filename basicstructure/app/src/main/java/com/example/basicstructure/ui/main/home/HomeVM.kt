package com.example.basicstructure.ui.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.baselib.base.BaseViewModel
import com.example.basicstructure.bean.ArticleListBean
import kotlinx.coroutines.async

/***
 * 首页
 */

class HomeVM : BaseViewModel() {
    private val repo by lazy {
        HomeRepo()
    }

    /**
     *  文章列表
     */

    private val _articleList = MutableLiveData<MutableList<ArticleListBean>>()

    /**
     *对外部提供只读的LiveData
     */

    val articleList : LiveData<MutableList<ArticleListBean>> = _articleList


    /**
     * banner
     */
    private val _banner = MutableLiveData<MutableList<BannerBean>>()


    /**
     * 对外部提供只读的LiveData
     */
    val banner: LiveData<MutableList<BannerBean>> = _banner


    /**
     * 获取Banner
     */
    fun getBanner() {
        launch {
            _banner.value = repo.getBanner()
        }
    }

    /**
     * 获取首页文章列表，包括banner
     */
    fun getArticle() {
        launch {
            val list = mutableListOf<ArticleListBean>()
            val articles = viewModelScope.async {
                repo.getArticles()
            }

            val topArticle = viewModelScope.async {
                repo.getTopArticles()
            }
            list.addAll(topArticle.await())
            list.addAll(articles.await())
            _articleList.value = list
        }
    }
}