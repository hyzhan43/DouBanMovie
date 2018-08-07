package zqx.rj.com.baselibrary.common

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View


/**
 * 项目名：  DouBanMovie
 * 包名：    zqx.rj.com.baselibrary.common
 * 文件名：  RecyclerItemDecoration
 * 创建者：  ZQX
 * 创建时间：2018/8/5 3:15
 * 描述：    RecyclerView item 间距
 */
class RecyclerItemDecoration(var space: Int = 10) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {


        outRect?.let {
            it.left = space
            it.bottom = space

            if (parent?.getChildLayoutPosition(view)!! % 3 == 0) {
                it.left = 0;
            }
        }
    }
}