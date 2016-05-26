package com.martin.snframework.widgets.tab;

import android.content.Context;
import android.content.res.TypedArray;

import android.util.AttributeSet;
import android.view.ViewGroup;

import com.martin.snframework.R;
import com.sn.controlers.slidingtab.SNSlidingTabItem;


/**
 * Created by xuhui on 15/8/12.
 */
public class XMTabItem extends SNSlidingTabItem {

    String text;

    int textColor;


    public int getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(int selectedColor) {
        this.selectedColor = selectedColor;
    }


    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        if (textColor != selectedColor)
            this.textColor = textColor;

        $this.id(R.id.tvTitle).textColor(textColor);
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        $this.id(R.id.tvTitle).text(text);
    }

    int selectedColor;


    public XMTabItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        $this = $.layoutInflateResId(R.layout.widget_xm_tab_bar_item, (ViewGroup) $this.toView());

        TypedArray array = $.obtainStyledAttr(attrs, R.styleable.SNImageTextTabItem);

        text = array.getString(R.styleable.SNImageTextTabItem_android_text);

        textColor = array.getColor(R.styleable.SNImageTextTabItem_android_textColor, 0xFF000000);

        selectedColor = array.getColor(R.styleable.SNImageTextTabItem_selected_color, 0xFF555555);

        array.recycle();

        if (!$.util.strIsNullOrEmpty(text))
            setText(text);

        setTextColor(textColor);
    }


}
