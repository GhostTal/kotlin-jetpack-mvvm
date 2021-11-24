package com.example.baselib.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.baselib.utils.ColorUtils
import com.example.baselib.utils.StatusUtils

/**
 *  mvvm 基础 activity
 * */

abstract class BaseVmActivity : AppCompatActivity() {
    private var mActivityProvider: ViewModelProvider? = null
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        getLayoutId()?.let {
            setContentView(it)
        }
        setStatusColor()
        setSystemInvadeBlack()
        initViewModel()
        observe()
        init(savedInstanceState)
    }

    /**
     * 注册观察者
     */
    open fun observe() {}

    /**
     * 初始化viewModel
     * 之所以没有设计为抽象，是因为部分简单activity可能不需要viewModel
     * observe同理
     */
    open fun initViewModel() {}


    /**
     * 沉浸式状态
     */
    open fun setSystemInvadeBlack() {
        //第二个参数是是否沉浸,第三个参数是状态栏字体是否为黑色。
        StatusUtils.setSystemStatus(this, true, true)
    }

    /**
     * 设置状态栏背景颜色
     */
    open fun setStatusColor() {
        StatusUtils.setUseStatusBarColor(this, ColorUtils.parseColor("#00ffffff"))
    }

    /**
     * 获取layout布局
     */
    abstract fun getLayoutId(): Int?

    /**
     * activity入口
     */
    abstract fun init(savedInstanceState: Bundle?)
}