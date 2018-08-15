package zqx.rj.com.doubanmovie.fragment.movie

import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.frag_movie_category.*
import org.jetbrains.anko.support.v4.startActivity
import rx.Observable
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.baselibrary.base.BaseSubscriber
import zqx.rj.com.baselibrary.common.execute
import zqx.rj.com.baselibrary.common.net.RetrofitFactory
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.activities.MoviesDetailActivity
import zqx.rj.com.doubanmovie.adapter.CommonAdapter
import zqx.rj.com.doubanmovie.adapter.MoviesAdapter
import zqx.rj.com.doubanmovie.api.ApiService
import zqx.rj.com.doubanmovie.bean.movies.Movie
import zqx.rj.com.doubanmovie.bean.movies.MoviesData

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.fragment
 * 文件名：  CategoryFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/3 0:29
 * 描述：    电影 item
 */
class CategoryFragment : BaseFragment() {

    private var type: Int = 0
    private lateinit var adapter: MoviesAdapter

    companion object {
        fun newInstance(type: Int): CategoryFragment {
            val fragment = CategoryFragment()
            fragment.type = type
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.frag_movie_category
    }

    override fun initView() {

        mMovieRecyclerView.layoutManager = GridLayoutManager(context, 3)
        mMovieRecyclerView.isNestedScrollingEnabled = false
        adapter = MoviesAdapter()
        mMovieRecyclerView.adapter = adapter
        adapter.setListener(object : CommonAdapter.AdapterListener<Movie> {
            override fun onItemClick(holder: CommonAdapter.ViewHolder<Movie>, data: Movie) {
//                toast(data.id)
                startActivity<MoviesDetailActivity>("id" to data.id)
            }
        })

        mRefresh.setOnRefreshListener {
            if (mRefresh.isRefreshing){
                mRefresh.isRefreshing = false
            }
        }
    }

    override fun initData() {
        var observable = RetrofitFactory.instance.create(ApiService::class.java)
//                .getInTheatersMovies()
//                .execute(object : BaseSubscriber<MoviesData>() {
//                    override fun onNext(t: MoviesData) {
//                        adapter.replace(t.subjects)
//                    }
//                })
        var rspObservable: Observable<MoviesData>? = null

        when (type) {
            MovieFragment.InTheatersMovies -> rspObservable = observable.getInTheatersMovies()
            MovieFragment.ComingSoonMovies -> rspObservable = observable.getComingSoonMovies()
            MovieFragment.Top250Movies -> rspObservable = observable.getTop250Movies()
        }

        rspObservable?.execute(object : BaseSubscriber<MoviesData>() {
            override fun onNext(t: MoviesData) {
                adapter.replace(t.subjects)
            }
        })
    }
}