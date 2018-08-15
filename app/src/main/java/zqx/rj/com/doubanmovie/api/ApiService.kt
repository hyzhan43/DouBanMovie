package zqx.rj.com.doubanmovie.api

import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable
import zqx.rj.com.doubanmovie.bean.book.Book
import zqx.rj.com.doubanmovie.bean.book.BooksData
import zqx.rj.com.doubanmovie.bean.movies.MovieDetailData
import zqx.rj.com.doubanmovie.bean.movies.MoviesData

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.api
 * 文件名：  ApiService
 * 创建者：  ZQX
 * 创建时间：2018/8/3 0:13
 * 描述：    豆瓣电影 api
 */
interface ApiService {

    // 正在热映
    @GET("/v2/movie/in_theaters")
    fun getInTheatersMovies(): Observable<MoviesData>

    // 即将上映
    @GET("/v2/movie/coming_soon")
    fun getComingSoonMovies(): Observable<MoviesData>

    // Top250
    @GET("/v2/movie/top250")
    fun getTop250Movies(): Observable<MoviesData>

    @GET("/v2/movie/subject/{id}")
    fun getMoviesDetail(@Path("id") id: String): Observable<MovieDetailData>

    @GET("/v2/book/search")
    fun getBookResults(@Query("q") searchName: String,
                       @Query("start") start: Int,
                       @Query("count") count: Int): Observable<BooksData>
}