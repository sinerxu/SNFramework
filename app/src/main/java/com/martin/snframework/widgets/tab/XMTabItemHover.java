package com.martin.snframework.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;

import com.martin.snframework.R;
import com.sn.controlers.slidingtab.SNSlidingTabItemHover;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 15/8/12.
 */
public class XMTabItemHover extends SNSlidingTabItemHover {
    SNElement $hover;

    public XMTabItemHover(Context context, AttributeSet attrs) {
        super(context, attrs);
        $hover = $.layoutInflateResId(R.layout.widget_xm_tab_bar_hover, $this.toViewGroup(), false);
        $this.add($hover);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);

    }
}
