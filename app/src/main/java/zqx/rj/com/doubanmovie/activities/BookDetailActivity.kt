package zqx.rj.com.doubanmovie.activities

import android.annotation.SuppressLint
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_book_detail.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import zqx.rj.com.baselibrary.base.BaseActivity
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.bean.book.Book

class BookDetailActivity : BaseActivity() {
    override fun getContentViewResId(): Int {
        return R.layout.activity_book_detail
    }

    @SuppressLint("SetTextI18n")
    override fun initData() {

        val data: Book = intent.getSerializableExtra("data") as Book

        // 设置标题
        setToolBar(toolbar, data.subtitle)

        Glide.with(this)
                .load(data.image)
                .centerCrop()
                .into(mIvBookBigPoster)

        mTvName.text = data.title
        mTvAuthor.text = getAuthors(data.author)

        // 　\u3000\u3000  首行缩进
        mTvSummary.text = "\u3000\u3000 ${data.summary}"
        mTvAuthorIntro.text = "\u3000\u3000 ${data.author_intro}"
    }

    private fun getAuthors(authorsList: ArrayList<String>): String {

        if (authorsList.size <= 0)
            return ""

        var authors = ""
        for (index in authorsList.indices) {
            authors = "${authorsList.get(index)}、$authors"
        }
        return authors.substring(0, authors.length - 1)
    }
}
