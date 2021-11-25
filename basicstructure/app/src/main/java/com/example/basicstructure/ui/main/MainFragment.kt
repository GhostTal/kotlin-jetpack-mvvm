package com.example.basicstructure.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.baselib.base.BaseVmFragment
import com.example.basicstructure.R
import com.example.basicstructure.ui.main.home.HomeFragment
import com.example.basicstructure.ui.main.mine.MineFragment
import com.example.basicstructure.ui.main.square.SquareFragment

/**
 * des 主页面
 */
class MainFragment : BaseVmFragment() {
    override fun init(savedInstanceState: Bundle?) {
        // 初始化viewpager2

    }

    override fun getLayoutId(): Int? {
        return R.layout.fragment_main
    }

    private val fragmentList = arrayListOf<Fragment>()

    private val homeFragment by lazy { HomeFragment() }
    private val squareFragment by lazy { SquareFragment() }
    private val mineFragment by lazy { MineFragment() }

    init {
        fragmentList.apply {
            add(homeFragment)
            add(squareFragment)
            add(mineFragment)
        }
    }
}