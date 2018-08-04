package zqx.rj.com.doubanmovie.fragment

import android.support.design.widget.TabLayout.MODE_SCROLLABLE
import kotlinx.android.synthetic.main.frag_movie_main.*
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.adapter.MovieTabAdapter
import zqx.rj.com.doubanmovie.fragment.movie.TheatersFragment

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.fragment
 * 文件名：  MovieFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/2 23:25
 * 描述：    电影 Fragment
 */
class MovieFragment : BaseFragment() {
    override fun getLayoutResId(): Int {
        return R.layout.frag_movie_main
    }

    override fun initView() {
        val tabAdapter = MovieTabAdapter(childFragmentManager, getTabData(), getTabTitle())
        vpMovie.adapter = tabAdapter
        tabLayout.setupWithViewPager(vpMovie)
        tabLayout.tabMode = MODE_SCROLLABLE
    }

    private fun getTabTitle(): ArrayList<String> {

        val titles = arrayListOf<String>()
        titles.add("正在热映")
        titles.add("即将上映")
        titles.add("Top250")
        titles.add("口碑榜")
        titles.add("北美票房榜")
        titles.add("新片榜")
        return titles
    }

    private fun getTabData(): ArrayList<BaseFragment> {

        val fragments = arrayListOf<BaseFragment>()

        fragments.add(TheatersFragment())
        fragments.add(TheatersFragment())
        fragments.add(TheatersFragment())
        fragments.add(TheatersFragment())
        fragments.add(TheatersFragment())
        fragments.add(TheatersFragment())

        return fragments
    }
}