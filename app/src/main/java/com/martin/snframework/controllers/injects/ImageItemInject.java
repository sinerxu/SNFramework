package com.martin.snframework.controllers.injects;

import android.graphics.Bitmap;

import com.martin.snframework.R;
import com.martin.snframework.models.TopicModel;
import com.sn.annotation.SNInjectElement;
import com.sn.interfaces.SNOnGetImageUrlListener;
import com.sn.interfaces.SNOnSetImageListenter;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 16/5/18.
 */
public class ImageItemInject extends BaseInject {


    @SNInjectElement(id = R.id.ivAvatar)
    SNElement ivAvatar;
    @SNInjectElement(id = R.id.tvNick)
    SNElement tvNick;

    public ImageItemInject(SNElement _v) {
        super(_v);
    }

    @Override
    public void onInjectUI() {
        super.onInjectUI();
        TopicModel model = getData(TopicModel.class);

        ivAvatar.image(model.getAvatar(), R.drawable.avatar_def, new SNOnSetImageListenter() {
            @Override
            public Bitmap onSetBitmap(Bitmap bitmap) {
                return $.util.imgCircle(bitmap);
            }
        }, new SNOnGetImageUrlListener() {
            @Override
            public String onGetRealUrl() {
                //这里一定要使用getData(TopicModel.class) 获取真实的对象
                return getAvatar();
            }
        });

        tvNick.text(model.getUsername());
    }


    String getAvatar() {
        return getData(TopicModel.class).getAvatar();
    }
}
