package zqx.rj.com.baselibrary.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.MenuItem
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
        ScreenAdapterTools.getInstance().loadView(window.decorView);
        mContext = this
        initIntentData()
        initView()
        initData()
    }

    /**
     *  设置 toolbar 标题
     */
    fun setToolBar(toolbar: Toolbar, title: String) {
        toolbar.title = title
        setSupportActionBar(toolbar)
        val supportActionBar = supportActionBar

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return true
    }

    abstract fun getContentViewResId(): Int
    open fun initIntentData() {}
    open fun initView() {}
    open fun initData() {}
}