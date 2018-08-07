package zqx.rj.com.baselibrary.base

import android.app.Application
import com.yatoooon.screenadaptation.ScreenAdapterTools

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.base
 * 文件名：  BaseApplication
 * 创建者：  ZQX
 * 创建时间：2018/8/6 1:37
 * 描述：    TODO
 */
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // 屏幕适配
        ScreenAdapterTools.init(this)
    }
}