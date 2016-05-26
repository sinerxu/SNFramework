package com.martin.snframework.controllers.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.martin.snframework.R;
import com.martin.snframework.controllers.injects.UserViewInject;
import com.sn.annotation.SNInjectElement;
import com.sn.core.SNPullRefreshManager;
import com.sn.interfaces.SNAdapterOnItemClickListener;
import com.sn.interfaces.SNAppEventListener;
import com.sn.interfaces.SNPullRefreshManagerListener;
import com.sn.interfaces.SNThreadDelayedListener;
import com.sn.main.SNElement;
import com.sn.models.SNAdapterViewInject;

import java.util.ArrayList;
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
        $.contentView(R.layout.activity_pull_to_refresh, this);

        actions = new ArrayList<String>();
        actions.add("加载网络图片");
        actions.add("注册事件");
        actions.add("调用事件");
        actions.add("移除事件");
        actions.add("Tab");
        actions.add("Progress Bar");
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
                    }
                });
            }
        });

    }
}
