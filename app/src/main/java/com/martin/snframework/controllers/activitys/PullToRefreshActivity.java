package com.martin.snframework.controllers.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.martin.snframework.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import com.martin.snframework.controllers.injects.UserViewInject;
import com.martin.snframework.dialogs.CustomerLoadingDialog;
import com.martin.snframework.widgets.alert.CustomerAlert;
import com.sn.annotation.SNInjectElement;
import com.sn.core.SNHeaderManager;
import com.sn.core.SNLoadingBuilder;
import com.sn.core.SNLoadingDialogManager;
import com.sn.core.SNPullRefreshManager;
import com.sn.dialog.SNImageBrowserDialog;
import com.sn.interfaces.SNAdapterOnItemClickListener;
import com.sn.interfaces.SNAppEventListener;
import com.sn.interfaces.SNOnClickListener;
import com.sn.interfaces.SNOnHttpResultListener;
import com.sn.interfaces.SNPullRefreshManagerListener;
import com.sn.interfaces.SNThreadDelayedListener;
import com.sn.main.SNConfig;
import com.sn.main.SNElement;
import com.sn.models.SNAdapterViewInject;
import com.sn.models.SNHeader;
import com.sn.postting.alert.SNAlert;
import com.sn.postting.alert.SNAlertBuilder;
import com.soundcloud.android.crop.*;
import com.soundcloud.android.crop.CropImageActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xuhui on 16/1/29.
 */
public class PullToRefreshActivity extends BaseActivity {

    @SNInjectElement(id = R.id.gvTest)
    SNElement gvTest;
    @SNInjectElement(id = R.id.svMain)
    SNElement svMain;
    SNPullRefreshManager<String> pullRefreshManager;
    List<String> actions;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
        initSliding();
    }

    @Override
    public int onLayout() {
        return R.layout.activity_pull_to_refresh;
    }

    @Override
    public void onInitNavBar() {
        super.onInitNavBar();
        showNavBar();
        navTitleBar.showNavMenu(new SNOnClickListener() {
            @Override
            public void onClick(SNElement view) {
                $.showSlidingLeft();
            }
        });
        navTitleBar.showNavTitle("SNFramework Demo");
    }


    void initList() {
        actions = new ArrayList<String>();
        actions.add("加载网络图片");
        actions.add("注册事件");
        actions.add("调用事件");
        actions.add("移除事件");
        actions.add("Tab");
        actions.add("Progress Bar");
        actions.add("图片浏览器");
        actions.add("弹出alert");
        actions.add("自定义alert");
        actions.add("弹出loading");
        actions.add("自定义loading");
        actions.add("还原alert");
        actions.add("还原loading");
        actions.add("图片裁剪");
        actions.add("获取api的cookie");
        actions.add("算命工具请求测试");
        actions.add("设置cookie访问网站");
        actions.add("改变颜色");
        actions.add("打开网页");
        actions.add("淘宝客助手");
        SNPullRefreshManager.create(svMain, new SNPullRefreshManagerListener() {
            @Override
            public void onRefresh(SNPullRefreshManager manager) {
                $.util.threadDelayed(1000, new SNThreadDelayedListener() {
                    @Override
                    public void onFinish() {
                        pullRefreshManager.setData(actions);
                        pullRefreshManager.success();
                    }
                });
            }

            @Override
            public void onLoadMore(final SNPullRefreshManager manager) {

            }

            @Override
            public void onCreate(SNPullRefreshManager manager) {
                pullRefreshManager = manager;
                manager.setData(actions);
                gvTest.bindListAdapter(manager, R.layout.adapter_user, UserViewInject.class);
                gvTest.itemClick(new SNAdapterOnItemClickListener() {
                    @Override
                    public void onItemClick(SNAdapterViewInject holder) {
                        if (holder.getPos() == 0)
                            startActivityAnimate(ImageListActivity.class);
                        if (holder.getPos() == 1) {
                            $.setAppEventListener("test", new SNAppEventListener() {
                                @Override
                                public void onEvent(Intent args) {
                                    $.alert("hello world!");
                                }
                            });
                        }
                        if (holder.getPos() == 2) {
                            $.fireAppEventListener("test");
                        }
                        if (holder.getPos() == 3)
                            $.removeAppEventListener("test");
                        if (holder.getPos() == 4)
                            startActivityAnimate(TabMainActivity.class);
                        if (holder.getPos() == 5)
                            startActivityAnimate(ProgressBarActivity.class);
                        if (holder.getPos() == 6) {
                            ArrayList<Bitmap> urls = new ArrayList<Bitmap>();
                            urls.add($.readBitMap(R.drawable.avatar));
                            urls.add($.readBitMap(R.drawable.hover_bg));
//                            urls.add("http://img0.imgtn.bdimg.com/it/u=4048200091,3296984835&fm=21&gp=0.jpg");
//                            urls.add("http://img1.ph.126.net/IuICAN2Z9KW0MCYIO4y7eg==/6598226452889083211.jpg");
//                            urls.add("http://pic23.nipic.com/20120910/7341593_224514826000_2.jpg");
//                            urls.add("http://pic41.nipic.com/20140505/6099952_121948164122_2.jpg");
                            SNImageBrowserDialog imageBrowserDialog = new SNImageBrowserDialog($.getContext());
                            //imageBrowserDialog.setUrls(urls);
                            imageBrowserDialog.setBitmap(urls);
                            imageBrowserDialog.setDefaultShow(1);
                            imageBrowserDialog.show();
                        }

                        if (holder.getPos() == 7)
                            $.alert("hello！");
                        if (holder.getPos() == 8) {
                            SNAlertBuilder.setCustomerAlert(CustomerAlert.class);
                            $.alert("自定义alert");
                        }

                        if (holder.getPos() == 9) {
                            $.openLoading();
                            $.util.threadDelayed(1000, new SNThreadDelayedListener() {
                                @Override
                                public void onFinish() {
                                    $.closeLoading();
                                }
                            });
                        }
                        if (holder.getPos() == 10) {
                            SNLoadingBuilder.setCustomerLoadingDialog(CustomerLoadingDialog.class);
                            $.alert("设置成功！");
                        }
                        if (holder.getPos() == 11) {
                            SNAlertBuilder.resetCustomerAlert();
                            $.alert("还原alert成功！");
                        }
                        if (holder.getPos() == 12) {
                            SNLoadingBuilder.resetCustomerLoadingDialog();
                            $.alert("还原loading成功！");
                        }
                        if (holder.getPos() == 13) {
                            startActivityAnimate(com.martin.snframework.controllers.activitys.CropImageActivity.class);
                        }
                        if (holder.getPos() == 14) {

                            $.get("http://192.168.1.109:86/mobile/login?username=smm&password=123456", new SNOnHttpResultListener() {
                                @Override
                                public void onSuccess(int statusCode, ArrayList<SNHeader> headers, String result) {
                                    String value = SNHeaderManager.findByName(headers, "Set-Cookie");
                                    HashMap<String, String> req_headers = new HashMap<String, String>();
                                    req_headers.put("Cookie", value);
                                    $.get("http://192.168.1.109:86/mobile/getmenus", req_headers, new SNOnHttpResultListener() {
                                        @Override
                                        public void onSuccess(int statusCode, ArrayList<SNHeader> headers, String result) {
                                            $.toast(result, 2000);
                                        }

                                        @Override
                                        public void onFailure(int statusCode, ArrayList<SNHeader> headers, String result) {

                                        }
                                    });
                                }

                                @Override
                                public void onFailure(int statusCode, ArrayList<SNHeader> headers, String result) {

                                }
                            });
                        }
                        if (holder.getPos() == 15) {
                            startActivityAnimate(MingToolsActivity.class);
                        }
                        if (holder.getPos() == 16) {
                            startActivityAnimate(CookieWebActivity.class);
                        }
                        if (holder.getPos() == 17) {
                            gvTest.backgroundColor($.util.colorParse("#12000000"));
                        }
                        if (holder.getPos() == 18) {
                            startActivityAnimate(WebBrowserActivity.class);
                        }
                        if (holder.getPos() == 19) {
                            startActivityAnimate(WebBrowserActivity.class);
                        }
                    }
                });
            }
        });
    }


    void initSliding() {
        $.slidingMode(SlidingMenu.LEFT);
        $.slidingLeftView(R.layout.view_sliding_left);
        $.slidingOffset($.px(70));
        $.slidingShadowWidth($.px(5));
        $.slidingLeftShadow(R.drawable.nav_left_shadow);
    }
}
