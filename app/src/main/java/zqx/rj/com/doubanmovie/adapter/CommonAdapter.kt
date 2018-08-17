package zqx.rj.com.doubanmovie.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import zqx.rj.com.doubanmovie.R

/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.doubanmovie.adapter
 * 文件名：  CommonAdapter
 * 创建者：  ZQX
 * 创建时间：2018/8/5 0:15
 * 描述：    RecyclerAdapter 封装
 */
abstract class CommonAdapter<Data>(var mData: ArrayList<Data> = ArrayList(), var mListener: AdapterListener<Data>? = null) :
        RecyclerView.Adapter<CommonAdapter.ViewHolder<Data>>(), View.OnClickListener {

    // 返回布局文件
    abstract fun getItemLayoutId(): Int

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder<Data> {
        val inflater = LayoutInflater.from(parent?.context)

        val root: View = inflater.inflate(getItemLayoutId(), parent, false)
        val holder: ViewHolder<Data> = onCreateViewHolder(root, viewType)

        root.setTag(R.id.tag_recycler_holder, holder)
        root.setOnClickListener(this)

        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder<Data>?, position: Int) {
        // 得到需要绑定的数据
        val data = mData.get(position)
        holder?.onBind(data);
    }

    protected abstract fun onCreateViewHolder(root: View, viewType: Int): ViewHolder<Data>

    abstract class ViewHolder<Data>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun onBind(data: Data)
    }

    override fun onClick(v: View?) {
        val viewHolder: ViewHolder<Data> = v?.getTag(R.id.tag_recycler_holder) as ViewHolder<Data>

        mListener?.let {
            // 获取 点击 position
            val pos = viewHolder.adapterPosition
            it.onItemClick(viewHolder, mData.get(pos))
        }
    }

    /**
     * 替换一个新的集合，其中包括了清空
     */
    fun replace(dataList: ArrayList<Data>?) {
        mData.clear()

        if (dataList != null) {
            mData.addAll(dataList)
            notifyDataSetChanged()
        }
    }

    /**
     *  往集合追加 数据
     */
    fun add(dataList: ArrayList<Data>?){
        if (dataList != null) {
            mData.addAll(dataList)
            notifyDataSetChanged()
        }
    }

    fun setListener(listener: AdapterListener<Data>) {
        this.mListener = listener
    }

    interface AdapterListener<Data> {
        fun onItemClick(holder: ViewHolder<Data>, data: Data)
    }
}