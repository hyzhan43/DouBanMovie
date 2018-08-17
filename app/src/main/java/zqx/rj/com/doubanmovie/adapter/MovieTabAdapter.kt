package zqx.rj.com.doubanmovie.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import zqx.rj.com.baselibrary.base.BaseFragment

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  MovieTabAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/2 23:33
 * 描述：    TabLayout Adapter
 */
class MovieTabAdapter(fm: FragmentManager, var fragmentList: ArrayList<BaseFragment>,
                      var titleList: ArrayList<String>) : FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titleList.get(position)
    }
}