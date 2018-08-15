package zqx.rj.com.doubanmovie.adapter

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movies_item.view.*
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.bean.movies.Movie

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  MoviesAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/4 20:04
 * 描述：    movies Adapter
 */
class MoviesAdapter : CommonAdapter<Movie>() {
    override fun getItemLayoutId(): Int {
        return R.layout.movies_item
    }

    override fun onCreateViewHolder(root: View, viewType: Int): ViewHolder {
        return ViewHolder(root)
    }

    class ViewHolder(root: View) : CommonAdapter.ViewHolder<Movie>(root) {

        val context = root.context
        val moviePoster = root.mMoviePoster
        var movieAverage = root.mMovieAverage
        var movieName = root.mMovieName

        var prefix = root.resources.getString(R.string.cinema_score)


        override fun onBind(data: Movie) {

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