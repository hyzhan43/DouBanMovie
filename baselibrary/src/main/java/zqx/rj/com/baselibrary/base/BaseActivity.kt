package zqx.rj.com.baselibrary.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yatoooon.screenadaptation.ScreenAdapterTools

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.base
 * 文件名：  BaseActivity
 * 创建者：  ZQX
 * 创建时间：2018/8/2 19:46
 * 描述：    所有 Activity 的父类
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getContentViewResId())
        //ScreenAdapterTools.getInstance().loadView(window.decorView);
        mContext = this
        initIntentData()
        initView()
        initData()
    }

    abstract fun getContentViewResId(): Int
    open fun initIntentData(){}
    open fun initView() {}
    open fun initData() {}
}