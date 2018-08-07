package zqx.rj.com.doubanmovie.bean

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.bean
 * 文件名：  MovieDetailData
 * 创建者：  ZQX
 * 创建时间：2018/8/7 1:48
 * 描述：    TODO
 */
data class MovieDetailData(var rating: MoviesRating,
                           var wish_count: Int,
                           var year: String,
                           var images: MovieImages,
                           var title: String,
                           var countries: ArrayList<String>,
                           var genres: ArrayList<String>,
                           var casts: ArrayList<MoviePerson>,
                           var summary: String,
                           var directors: ArrayList<MoviePerson>,
                           var comments_count: Int)