package zqx.rj.com.baselibrary.common.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import zqx.rj.com.baselibrary.common.BaseConstant
import java.util.concurrent.TimeUnit

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.common.net
 * 文件名：  RetrofitFactory
 * 创建者：  ZQX
 * 创建时间：2018/8/2 23:56
 * 描述：    Retrofit 封装
 */
class RetrofitFactory private constructor() {

    private val retrofit: Retrofit

    companion object {
        val instance: RetrofitFactory by lazy {
            RetrofitFactory()
        }
    }

    init {
        retrofit = Retrofit.Builder()
                .baseUrl(BaseConstant.SERVER_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(initOkHttpClient())
                .build()
    }

    fun<T> create(service: Class<T>): T {
        return retrofit.create(service)
    }

    private fun initOkHttpClient(): OkHttpClient? {
        return OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

}