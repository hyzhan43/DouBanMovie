package zqx.rj.com.doubanmovie.api

import retrofit2.http.GET
import rx.Observable
import zqx.rj.com.doubanmovie.bean.InTheatersData

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.api
 * 文件名：  ApiService
 * 创建者：  ZQX
 * 创建时间：2018/8/3 0:13
 * 描述：    TODO
 */
interface ApiService {

    @GET("v2/movie/in_theaters")
    fun getInTheatersMovies(): Observable<InTheatersData>
}