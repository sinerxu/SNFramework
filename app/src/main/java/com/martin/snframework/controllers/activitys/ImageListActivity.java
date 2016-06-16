package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.martin.snframework.controllers.injects.ImageItemInject;
import com.martin.snframework.managers.ManagerFactory;
import com.martin.snframework.managers.async.AsyncManagerResult;
import com.martin.snframework.managers.async.listeners.AsyncManagerListener;
import com.martin.snframework.managers.main.interfaces.ITopicManager;
import com.martin.snframework.models.TopicModel;
import com.sn.annotation.SNInjectElement;
import com.sn.core.SNPullRefreshManager;
import com.sn.interfaces.SNAdapterOnItemClickListener;
import com.sn.interfaces.SNPullRefreshManagerListener;
import com.sn.main.SNElement;
import com.sn.models.SNAdapterViewInject;

import java.util.List;

/**
 * Created by xuhui on 16/5/18.
 */
public class ImageListActivity extends BaseActivity {
    @SNInjectElement(id = R.id.lvTest)
    SNElement lvTest;
    @SNInjectElement(id = R.id.svMain)
    SNElement svMain;
    SNPullRefreshManager<TopicModel> pullRefreshManager;
    ITopicManager topicManager;
    int pageSize = 20;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        $.contentView(R.layout.activity_imagelist);
        topicManager = ManagerFactory.instance($).createTopicManager();
        SNPullRefreshManager.create(svMain, pageSize, new SNPullRefreshManagerListener() {
            @Override
            public void onRefresh(SNPullRefreshManager manager) {
                //刷新
                loadTopic(true, false);
            }

            @Override
            public void onLoadMore(SNPullRefreshManager manager) {
                //加载更多
                loadTopic(false, false);
            }

            @Override
            public void onCreate(SNPullRefreshManager manager) {
                pullRefreshManager = manager;
                lvTest.bindListAdapter(manager, R.layout.adapter_imageitem, ImageItemInject.class);
                loadTopic(true, true);
                lvTest.itemClick(new SNAdapterOnItemClickListener() {
                    @Override
                    public void onItemClick(SNAdapterViewInject holder) {
                        try {
                            $.alert($.metaDataActivity("test") + $.metaDataApplication("test2"));
                        } catch (Exception e) {
                            e.printStackTrace();
                            $.alert(e.getMessage());
                        }
                    }
                });
            }
        });
    }
    void loadTopic(final boolean isRefresh, final boolean isOpenLoadding) {
        if (isOpenLoadding) $.openLoading();
        topicManager.getTopics(pullRefreshManager.getPage(), pullRefreshManager.getPageSize(), new AsyncManagerListener() {
            @Override
            public void onResult(AsyncManagerResult result) {
                if (isOpenLoadding) $.closeLoading();
                if (result.isSuccess()) {
                    List<TopicModel> list = result.getResult(List.class);
                    if (list.size() == 0) {
                        pullRefreshManager.done();
                    } else {
                        if (isRefresh)
                            pullRefreshManager.setData(list);
                        else
                            pullRefreshManager.addData(list);
                        pullRefreshManager.success();
                    }
                } else {
                    pullRefreshManager.error(result.getMessage());
                }
            }
        });
    }
}
