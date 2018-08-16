package zqx.rj.com.doubanmovie.fragment.book

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener
import kotlinx.android.synthetic.main.frag_book_main.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import zqx.rj.com.baselibrary.base.BaseFragment
import zqx.rj.com.baselibrary.base.BaseSubscriber
import zqx.rj.com.baselibrary.common.execute
import zqx.rj.com.baselibrary.common.net.RetrofitFactory
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.activities.BookDetailActivity
import zqx.rj.com.doubanmovie.adapter.BookAdapter
import zqx.rj.com.doubanmovie.adapter.CommonAdapter
import zqx.rj.com.doubanmovie.api.ApiService
import zqx.rj.com.doubanmovie.bean.book.Book
import zqx.rj.com.doubanmovie.bean.book.BooksData

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.fragment
 * 文件名：  BookFragment
 * 创建者：  ZQX
 * 创建时间：2018/8/4 19:57
 * 描述：    图书搜索页面
 */
class BookFragment : BaseFragment(), CommonAdapter.AdapterListener<Book> {

    private lateinit var adapter: BookAdapter
    private var start: Int = 0
    private var count: Int = 5

    override fun getLayoutResId(): Int {
        return R.layout.frag_book_main
    }

    override fun initView() {

        mBookRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = BookAdapter()
        adapter.setListener(this)
        mBookRecyclerView.adapter = adapter


        mBtnCheck.setOnClickListener {
            loadData(start, count)

            mBtnCheck.isEnabled = false
        }

        // 禁止刷新
        mRefresh.setEnableRefresh(false)
        // 开启加载更多
        mRefresh.setEnableLoadMore(true)

        mRefresh.setOnLoadMoreListener {
            //start = start + count
            loadData(start, count * 2)
        }
    }

    private fun loadData(start: Int, count: Int) {
        RetrofitFactory.instance.create(ApiService::class.java)
                .getBookResults(mEtInput.text.toString(), start, count)
                .execute(object : BaseSubscriber<BooksData>() {
                    override fun onNext(t: BooksData) {
                        setResultDatas(t)
                    }

                    override fun onError(e: Throwable?) {
                        super.onError(e)
                        toast(e.toString())
                    }
                })
    }

    private fun setResultDatas(t: BooksData) {

        if (t.books.size == 0) {
            toast(resources.getString(R.string.search_error))
            return
        }
        adapter.replace(t.books)
        mBtnCheck.isEnabled = true
        mRefresh.finishLoadMore()
    }

    override fun onItemClick(holder: CommonAdapter.ViewHolder<Book>, data: Book) {
        startActivity<BookDetailActivity>("data" to data)
    }
}