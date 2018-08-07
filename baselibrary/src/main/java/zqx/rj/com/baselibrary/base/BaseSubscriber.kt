package zqx.rj.com.baselibrary.base

import rx.Subscriber

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.base
 * 文件名：  BaseSubscriber
 * 创建者：  ZQX
 * 创建时间：2018/8/5 1:16
 * 描述：    TODO
 */
open class BaseSubscriber<T>: Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}