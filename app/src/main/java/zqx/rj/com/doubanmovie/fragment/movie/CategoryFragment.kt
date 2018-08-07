package zqx.rj.com.doubanmovie.fragment.movie

import android.support.v7.widget.GridLayoutManager
import kotlinx.android.synthetic.main.frag_movie_in_theaters.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import rx.Observable
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.baselibrary.base.BaseSubscriber
import zqx.rj.com.baselibrary.common.execute
import zqx.rj.com.baselibrary.common.net.RetrofitFactory
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.activities.MoviesDetailActivity
import zqx.rj.com.doubanmovie.adapter.CommonAdapter
import zqx.rj.com.doubanmovie.adapter.TheatersMoviesAdapter
import zqx.rj.com.doubanmovie.api.ApiService
import zqx.rj.com.doubanmovie.bean.Movies
import zqx.rj.com.doubanmovie.bean.MoviesBaseData

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.fragment
 * 文件名：  CategoryFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/3 0:29
 * 描述：    正在热映
 */
class CategoryFragment : BaseFragment() {

    private var type: Int = 0
    private lateinit var adapter: TheatersMoviesAdapter

    companion object {
        fun newInstance(type: Int): CategoryFragment {
            val fragment = CategoryFragment()
            fragment.type = type
            return fragment
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.frag_movie_in_theaters
    }

    override fun initView() {

        movieRecyclerView.layoutManager = GridLayoutManager(context, 3)
        adapter = TheatersMoviesAdapter()
        movieRecyclerView.adapter = adapter
        adapter.setListener(object : CommonAdapter.AdapterListener<Movies> {
            override fun onItemClick(holder: CommonAdapter.ViewHolder<Movies>, data: Movies) {
                toast(data.id)
                startActivity<MoviesDetailActivity>("id" to data.id)
            }
        })
    }

    override fun initData() {
        var observable = RetrofitFactory.instance.create(ApiService::class.java)
//                .getInTheatersMovies()
//                .execute(object : BaseSubscriber<MoviesBaseData>() {
//                    override fun onNext(t: MoviesBaseData) {
//                        adapter.replace(t.subjects)
//                    }
//                })
        var rspObservable: Observable<MoviesBaseData>? = null

        when (type) {
            MovieFragment.InTheatersMovies -> rspObservable = observable.getInTheatersMovies()
            MovieFragment.ComingSoonMovies -> rspObservable = observable.getComingSoonMovies()
            MovieFragment.Top250Movies -> rspObservable = observable.getTop250Movies()
        }

        rspObservable?.execute(object : BaseSubscriber<MoviesBaseData>() {
            override fun onNext(t: MoviesBaseData) {
                adapter.replace(t.subjects)
            }
        })
    }
}