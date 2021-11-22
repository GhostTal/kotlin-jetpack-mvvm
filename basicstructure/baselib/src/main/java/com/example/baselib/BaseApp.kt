package com.example.baselib

import android.app.Application
import android.content.Context

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        baseApp = this;
    }

    companion object {
        private lateinit var baseApp: BaseApp
        fun getContext() : Context {
            return baseApp
        }
    }
}