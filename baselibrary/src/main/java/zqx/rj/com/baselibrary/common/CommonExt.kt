package zqx.rj.com.baselibrary.common

import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import zqx.rj.com.baselibrary.base.BaseSubscriber

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.common
 * 文件名：  CommonExt
 * 创建者：  ZQX
 * 创建时间：2018/8/5 1:58
 * 描述：    observable 扩展函数
 */

fun <T> Observable<T>.execute(subscriber: BaseSubscriber<T>){

    // 指定 Subscriber 的回调发生在主线程
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())   // 指定 subscribe() 发生在 IO 线程
            .subscribe(subscriber)
}