package zqx.rj.com.doubanmovie.activities

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_movies_detail.*
import zqx.rj.com.baselibrary.base.BaseActivity
import zqx.rj.com.baselibrary.base.BaseSubscriber
import zqx.rj.com.baselibrary.common.execute
import zqx.rj.com.baselibrary.common.net.RetrofitFactory
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.api.ApiService
import zqx.rj.com.doubanmovie.bean.MovieDetailData
import zqx.rj.com.doubanmovie.bean.MoviePerson

class MoviesDetailActivity : BaseActivity() {

    override fun getContentViewResId(): Int {
        return R.layout.activity_movies_detail
    }

    override fun initData() {

        RetrofitFactory.instance.create(ApiService::class.java)
                .getMoviesDetail(intent.getStringExtra("id"))
                .execute(object : BaseSubscriber<MovieDetailData>() {
                    override fun onNext(t: MovieDetailData) {
                        setData(t)
                    }
                })
    }

    @SuppressLint("SetTextI18n")
    private fun setData(t: MovieDetailData) {

        // 背景
        Glide.with(this)
                .load(t.images.large)
                .centerCrop()
                // “14”：设置模糊度(在0.0到25.0之间)，默认”25";"3":图片缩放比例,默认“1”。
                .bitmapTransform(BlurTransformation(this, 15, 3))
                .placeholder(R.color.grey_200)
                .into(mIvBgPoster)

        mTvCountries.text = "${t.countries} · ${t.year}"

        mTvLove.text = String.format(mTvLove.text as String, t.wish_count)
        mTvComment.text = String.format(mTvComment.text as String, t.comments_count)

        // 电影海报
        Glide.with(this)
                .load(t.images.large)
                .centerCrop()
                .placeholder(R.color.grey_200)
                .into(mIvPoster)

        mTvScore.text = String.format(mTvScore.text as String, t.rating.average)

        val directors = getDirectors(t.directors)
        mTvDirectors.text = String.format(mTvDirectors.text as String, directors)

        val casts = getCasts(t.casts)
        mTvCasts.text = String.format(mTvCasts.text as String, casts)

        val genres = getGenres(t.genres)
        mTvGenres.text = String.format(mTvGenres.text as String, genres)

        mTvSummary.text = t.summary
    }

    private fun getGenres(genresList: ArrayList<String>): String {
        var genres = ""
        for (genre in genresList) {
            genres = "$genres、$genre"
        }
        return genres.substring(1, genres.length)
    }

    private fun getCasts(castsList: ArrayList<MoviePerson>): String {

        var casts = ""
        for (cast in castsList) {
            casts = "$casts/${cast.name}"
        }

        return casts.substring(0, casts.length - 1)
    }

    private fun getDirectors(directorsList: ArrayList<MoviePerson>): String {
        var directors = ""
        for (director in directorsList) {
            directors = "$directors、${director.name}"
        }
        return directors.substring(1, directors.length)
    }


}
