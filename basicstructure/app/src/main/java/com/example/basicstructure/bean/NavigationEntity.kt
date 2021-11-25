package com.example.basicstructure.bean

class NavigationEntity {
    private var cid: Int = 0
    private var name: String? = null
    private var articles: List<ArticleBean.DatasBean?>? = null

    fun getCid(): Int {
        return cid
    }

    fun setCid(cid: Int) {
        this.cid = cid
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getArticles(): List<ArticleBean.DatasBean?>? {
        return articles
    }

    fun setArticles(articles: List<ArticleBean.DatasBean?>?) {
        this.articles = articles
    }
}
