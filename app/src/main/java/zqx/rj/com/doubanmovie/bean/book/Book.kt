package zqx.rj.com.doubanmovie.bean.book

import java.io.Serializable

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.bean.book
 * 文件名：  Book
 * 创建者：  ZQX
 * 创建时间：2018/8/13 0:29
 * 描述：    TODO
 */
class Book(var id: String,
           var author: ArrayList<String>,
           var subtitle: String,
           var pubdate: String,
           var image: String,
           var publisher: String,
           var title: String,
           var summary: String,
           var author_intro: String,
           var ebook_price: String) : Serializable
