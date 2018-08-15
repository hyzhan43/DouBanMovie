package zqx.rj.com.doubanmovie.adapter

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movies_casts_item.view.*
import zqx.rj.com.doubanmovie.R
import zqx.rj.com.doubanmovie.bean.movies.MoviePerson

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  CastsAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/8 0:41
 * 描述：    影人 适配器
 */
class CastsAdapter : CommonAdapter<MoviePerson>() {
    override fun getItemLayoutId(): Int {
        return R.layout.movies_casts_item
    }

    override fun onCreateViewHolder(root: View, viewType: Int): ViewHolder {
        return ViewHolder(root)
    }

    class ViewHolder(root: View) : CommonAdapter.ViewHolder<MoviePerson>(root) {

        val context = root.context
        val name = root.mTvName
        val cast = root.mIvCast

        override fun onBind(data: MoviePerson) {

            Glide.with(context)
                    .load(data.avatars.large)
                    .centerCrop()
                    .placeholder(R.color.grey_200)
                    .into(cast)

            name.text = data.name
        }
    }
}