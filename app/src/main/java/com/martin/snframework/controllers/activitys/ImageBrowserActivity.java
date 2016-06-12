package com.martin.snframework.controllers.activitys;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.interfaces.SNOnLoadImageFinishListener;
import com.sn.main.SNElement;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by xuhui on 16/5/26.
 */
public class ImageBrowserActivity extends BaseActivity {
    @SNInjectElement(id = R.id.scroImages)
    SNElement scroImages;
    ArrayList<SNElement> elements;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        $.contentView(R.layout.activity_image_browser);


        ArrayList<String> urls = new ArrayList<String>();
        urls.add("http://img0.imgtn.bdimg.com/it/u=4048200091,3296984835&fm=21&gp=0.jpg");
        urls.add("http://img1.ph.126.net/IuICAN2Z9KW0MCYIO4y7eg==/6598226452889083211.jpg");
        urls.add("http://pic23.nipic.com/20120910/7341593_224514826000_2.jpg");
        urls.add("http://pic41.nipic.com/20140505/6099952_121948164122_2.jpg");
        elements = new ArrayList<SNElement>();
        for (String url : urls) {
            SNElement elem = $.create(new ImageView(this));
            elem.image(url, new SNOnLoadImageFinishListener() {
                @Override
                public void onFinish(Bitmap bitmap) {

                }
            });
            elem.scaleType(ImageView.ScaleType.FIT_XY);
            elem.adjustViewBounds(true);
            elements.add(elem);
        }

        scroImages.bindScrollable(elements);
    }
}
