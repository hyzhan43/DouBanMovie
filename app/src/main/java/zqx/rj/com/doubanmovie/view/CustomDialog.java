package zqx.rj.com.doubanmovie.view;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import zqx.rj.com.doubanmovie.R;


/**
 * 项目名：  SmartButler
 * 包名：    zqx.rj.com.smartbutler.view
 * 文件名：  CustomDialog
 * 创建者：  ZQX
 * 创建时间：2018/4/13 8:55
 * 描述：    自定义 Dialog
 */

public class CustomDialog extends Dialog{

    // 定义模板
    public CustomDialog(Context context, int layout, int style) {
        this(context, WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                layout, style, Gravity.CENTER);
    }

    // 定义属性
    public CustomDialog(Context context, int width, int height, int layout, int style,
                        int gravity, int anim){

        super(context, style);

        // 设置属性
        setContentView(layout);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();

        // 决定 dialog 显示的大小，根据 layout
        // 这里设置 match_parent wrap_content 就是按照 layout 大小
        layoutParams.width = width;
        layoutParams.height = height;
        layoutParams.gravity = gravity;

        window.setAttributes(layoutParams);
        window.setWindowAnimations(anim);
    }

    // 实例
    public CustomDialog(Context context, int width, int height, int layout, int style, int gravity){
        this(context, width, height, layout, style, gravity, R.style.pop_anim_style);
    }
}
