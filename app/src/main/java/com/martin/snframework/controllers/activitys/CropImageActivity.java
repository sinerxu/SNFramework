package com.martin.snframework.controllers.activitys;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.interfaces.SNOnClickListener;
import com.sn.interfaces.SNOnImageLoadListener;
import com.sn.main.SNElement;
import com.sn.main.listeners.SNOnCropPhotoListener;

/**
 * Created by xuhui on 16/6/27.
 */
public class CropImageActivity extends BaseActivity {


    @SNInjectElement(id = R.id.ivMain)
    SNElement ivMain;
    @SNInjectElement(id = R.id.btnSelectImage)
    SNElement btnSelectImage;
    @SNInjectElement(id = R.id.btnTakeImage)
    SNElement btnTakeImage;
    @SNInjectElement(id = R.id.btnRemoteImage)
    SNElement btnRemoteImage;

    @Override
    public int onLayout() {
        return R.layout.activity_crop_image;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        btnSelectImage.click(new SNOnClickListener() {
            @Override
            public void onClick(SNElement view) {
                $.cropPhotoWithPick(new SNOnCropPhotoListener() {
                    @Override
                    public void onResult(Bitmap bitmap) {
                        ivMain.image(bitmap);
                    }
                });
            }
        });
        btnTakeImage.click(new SNOnClickListener() {
            @Override
            public void onClick(SNElement view) {
                $.cropPhotoWithTake(new SNOnCropPhotoListener() {
                    @Override
                    public void onResult(Bitmap bitmap) {
                        ivMain.image(bitmap);
                    }
                });
            }
        });
        btnRemoteImage.click(new SNOnClickListener() {
            @Override
            public void onClick(SNElement view) {
                $.openLoading();
                $.loadImage("http://img0.imgtn.bdimg.com/it/u=3368046022,3436603152&fm=21&gp=0.jpg", new SNOnImageLoadListener() {
                    @Override
                    public void onSuccess(Bitmap map) {
                        $.closeLoading();
                        $.cropPhoto($.bitmapToUri(map), new SNOnCropPhotoListener() {
                            @Override
                            public void onResult(Bitmap bitmap) {
                                ivMain.image(bitmap);
                            }
                        });
                    }
                    @Override
                    public void onFailure() {
                        $.closeLoading();
                        $.toast("图片加载失败", 2000);
                    }
                });
            }
        });
    }

    @Override
    public void onInitNavBar() {
        super.onInitNavBar();
        showNavBar();
        navTitleBar.showNavTitle("图片裁剪");
        navTitleBar.showNavBack();
    }
}
