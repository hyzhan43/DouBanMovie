package zqx.rj.com.baselibrary.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.base
 * 文件名：  BaseFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/2 19:50
 * 描述：    TODO
 */
abstract class BaseFragment: Fragment() {

    protected var mView: View? = null
    protected var mContext: Context? = null
    protected var isInit: Boolean = false
    protected var isLoad: Boolean = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        mView = inflater?.inflate(getLayoutResId(), container, false)
        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        isInit = true
        initView()
        initData()
    }

    abstract fun getLayoutResId(): Int

    open fun initView(){}

    open fun initData(){}
}