package zqx.rj.com.doubanmovie.fragment.movie

import kotlinx.android.synthetic.main.frag_movie_main.*
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.adapter.MovieTabAdapter

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.fragment
 * 文件名：  MovieFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/2 23:25
 * 描述：    电影 Fragment
 */
class MovieFragment : BaseFragment() {

    companion object {
        // 正在热映
        val InTheatersMovies = 1
        // 即将上映
        val ComingSoonMovies = 2
        // Top250
        val Top250Movies = 3
    }

    override fun getLayoutResId(): Int {
        return R.layout.frag_movie_main
    }

    override fun initView() {
        val tabAdapter = MovieTabAdapter(childFragmentManager, getTabData(), getTabTitle())
        vpMovie.adapter = tabAdapter
        tabLayout.setupWithViewPager(vpMovie)
    }

    private fun getTabTitle(): ArrayList<String> {

        val titles = arrayListOf<String>()
        titles.add("正在热映")
        titles.add("即将上映")
        titles.add("Top250")
        return titles
    }

    private fun getTabData(): ArrayList<BaseFragment> {

        val fragments = arrayListOf<BaseFragment>()

        fragments.add(CategoryFragment.newInstance(InTheatersMovies))
        fragments.add(CategoryFragment.newInstance(ComingSoonMovies))
        fragments.add(CategoryFragment.newInstance(Top250Movies))
        return fragments
    }
}