package zqx.rj.com.doubanmovie.adapter

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_theaters_movies.view.*
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.bean.Movies

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  TheatersMoviesAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/4 20:04
 * 描述：    正在热映 Adapter
 */
class TheatersMoviesAdapter : CommonAdapter<Movies>() {
    override fun getItemLayoutId(): Int {
        return R.layout.item_theaters_movies
    }

    override fun onCreateViewHolder(root: View, viewType: Int): ViewHolder {
        return ViewHolder(root)
    }

    class ViewHolder(root: View) : CommonAdapter.ViewHolder<Movies>(root) {

        val context = root.context
        val moviePoster = root.moviePoster
        var movieAverage = root.movieAverage
        var movieName = root.movieName

        var prefix = root.resources.getString(R.string.cinema_score)


        override fun onBind(data: Movies) {

            if (data != null){

            }

            // 电影海报
            Glide.with(context)
                    .load(data.images.large)
                    .centerCrop()
                    .placeholder(R.color.grey_200)
                    .into(moviePoster)


            // 影名
            movieName.text = data.title
            // 评分
            movieAverage.text = "${prefix} ${data.rating.average}"
        }
    }
}