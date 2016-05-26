package com.martin.snframework.widgets.tab;

import android.content.Context;
import android.util.AttributeSet;

import com.martin.snframework.R;
import com.sn.controlers.slidingtab.SNSlidingTabBar;

/**
 * Created by xuhui on 16/5/26.
 */
public class XMTabBar extends SNSlidingTabBar {
    public XMTabBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int onTabLayout() {
        return R.layout.widget_xm_tab_bar;
    }
}
