package zqx.rj.com.doubanmovie.adapter

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.books_item.view.*
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.bean.book.Book

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  BookAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/13 0:25
 * 描述：    图书适配器
 */
class BookAdapter : CommonAdapter<Book>() {
    override fun getItemLayoutId(): Int {
        return R.layout.books_item
    }

    override fun onCreateViewHolder(root: View, viewType: Int): ViewHolder {
        return ViewHolder(root)
    }

    inner class ViewHolder(root: View) : CommonAdapter.ViewHolder<Book>(root) {

        val context = root.context

        val image = root.mIvBookPoster
        val title = root.mTvTitle
        val stitle = root.mTvSTitle
        val price = root.mTvPrice
        val publisher = root.mTvPublisher
        val time = root.mTvTime

        override fun onBind(data: Book) {

            Glide.with(context)
                    .load(data.image)
                    .centerCrop()
                    .placeholder(R.color.grey_200)
                    .into(image)


            title.text = data.title
            stitle.text = data.subtitle
            price.text = data.ebook_price
            publisher.text = data.publisher
            time.text = data.pubdate
        }
    }
}