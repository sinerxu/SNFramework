package com.martin.snframework.widgets.tab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;

import com.sn.controlers.slidingtab.SNSlidingTab;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 15/8/13.
 */
public class XMTab extends SNSlidingTab {
    public XMTab(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    void resetItem() {
        if (this.getItemBox().$itemList != null && this.getItemBox().$itemList.size() > 0) {
            for (SNElement item : this.getItemBox().$itemList) {
                XMTabItem _item = item.toView(XMTabItem.class);
                _item.setTextColor(_item.getTextColor());

            }
        }
    }

    @Override
    public void onPage(int _page, SNElement _item, Fragment _content) {
        resetItem();
        XMTabItem item = _item.toView(XMTabItem.class);
        item.setTextColor(item.getSelectedColor());

        super.onPage(_page, _item, _content);
    }
}
