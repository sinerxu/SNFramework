package com.martin.snframework.controlers.activitys;

import android.os.Bundle;
import android.widget.GridView;

import com.martin.snframework.R;
import com.martin.snframework.controlers.injects.UserViewInject;
import com.martin.snframework.models.UserModel;
import com.sn.annotation.SNInjectElement;
import com.sn.controlers.pullrefresh.SNPullRefreshLayout;
import com.sn.core.SNPullRefreshManager;
import com.sn.interfaces.SNAdapterOnItemClickListener;
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
    SNPullRefreshManager<UserModel> pullRefreshManager;
    List<UserModel> userModels;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $.contentView(R.layout.activity_pull_to_refresh, this);

        userModels = new ArrayList<UserModel>();

        for (int i = 0; i < 30; i++) {
            UserModel userModel = new UserModel($);
            userModel.fromJson("{\"m\":\"Martin Xu\",\"a\":" + (24 + i) + "}");
            userModels.add(userModel);
        }

        SNPullRefreshManager.create(svMain, 20, new SNPullRefreshManagerListener() {
            @Override
            public void onRefresh(SNPullRefreshManager manager) {
                $.util.threadDelayed(1000, new SNThreadDelayedListener() {
                    @Override
                    public void onFinish() {
                        userModels = new ArrayList<UserModel>();
                        for (int i = 0; i < 20; i++) {
                            UserModel userModel = new UserModel($);
                            userModel.fromJson("{\"m\":\"Martin Xu\",\"a\":" + (i + 1) + "}");
                            userModels.add(userModel);
                        }
                        pullRefreshManager.setData(userModels);
                        pullRefreshManager.success();
                    }
                });
            }

            @Override
            public void onLoadMore(final SNPullRefreshManager manager) {
                $.util.threadDelayed(1000, new SNThreadDelayedListener() {
                    @Override
                    public void onFinish() {
                        for (int i = 0; i < 20; i++) {
                            UserModel userModel = new UserModel($);
                            userModel.fromJson("{\"m\":\"Martin Xu\",\"a\":" + ((i + 1) + ((pullRefreshManager.getPage() - 1) * pullRefreshManager.getPageSize())) + "}");
                            pullRefreshManager.addData(userModel);
                        }
                        manager.success();
                    }
                });

            }

            @Override
            public void onCreate(SNPullRefreshManager manager) {
                pullRefreshManager = manager;
                manager.setData(userModels);
                gvTest.bindListAdapter(manager, R.layout.adapter_user, UserViewInject.class);
                gvTest.itemClick(new SNAdapterOnItemClickListener() {
                    @Override
                    public void onItemClick(SNAdapterViewInject holder) {
                        $.alert("pos=" + holder.getPos());
                    }
                });
            }
        });

    }
}
