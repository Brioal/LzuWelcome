package com.brioal.lzuwelcome.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.brioal.lzuwelcome.R;


/**
 * 底部弹窗Fragment
 * Created by Brioal on 2016/8/4.
 */

public class GuideDetailFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // 使用不带Theme的构造器, 获得的dialog边框距离屏幕仍有几毫米的缝隙。
        Dialog dialog = new Dialog(getActivity(), R.style.BottomDialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 设置Content前设定
        dialog.setCanceledOnTouchOutside(true); // 外部点击取消
        dialog.setContentView(R.layout.fra_guide_detail);
        // 设置宽度为屏宽, 靠近屏幕底部。
        final Window window = dialog.getWindow();
        final WindowManager.LayoutParams lp = window.getAttributes();
        window.setWindowAnimations(R.style.AnimBottom);
        lp.gravity = Gravity.BOTTOM; // 紧贴底部
        lp.width = WindowManager.LayoutParams.MATCH_PARENT; // 宽度持平
        lp.height = getActivity().getWindowManager().getDefaultDisplay().getHeight() * 3 / 5;
        window.setAttributes(lp);
        return dialog;
    }
}
