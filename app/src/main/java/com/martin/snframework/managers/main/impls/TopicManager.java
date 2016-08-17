package com.martin.snframework.managers.main.impls;

import com.martin.snframework.managers.BaseManager;
import com.martin.snframework.managers.async.listeners.AsyncManagerListener;
import com.martin.snframework.managers.main.interfaces.ITopicManager;
import com.martin.snframework.models.TopicModel;
import com.sn.interfaces.SNOnHttpResultListener;
import com.sn.main.SNManager;
import com.sn.models.SNHeader;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xuhui on 16/5/18.
 */
public class TopicManager extends BaseManager implements ITopicManager {

    public TopicManager(SNManager _$) {
        super(_$);
    }

    @Override
    public void getTopics(int page, int pageSize, final AsyncManagerListener asyncManagerListener) {
        String url = $.util.strFormat("http://www.jiamingbaobao.com/api/v1/Forum/GetTopicsPage?id=1&pageIndex={0}&pageSize={1}", page, pageSize);

        $.get(url, new SNOnHttpResultListener() {
            @Override
            public void onSuccess(int statusCode, ArrayList<SNHeader> headers, String result) {
                try {
                    JSONObject jsonObject = $.util.jsonParse(result);
                    if ($.util.jsonNotIsNullOrNoHas(jsonObject, "Items")) {
                        JSONArray jsonArray = jsonObject.getJSONArray("Items");
                        List<TopicModel> results = new ArrayList<TopicModel>();
                        for (int i = 0; i < jsonArray.length(); i++) {
                            TopicModel model = new TopicModel($);
                            model.fromJson(jsonArray.getJSONObject(i));
                            results.add(model);
                        }
                        callBackSuccessResult(asyncManagerListener, results);
                    } else {
                        callBackError(asyncManagerListener);
                    }
                } catch (Exception e) {
                    callBackError(asyncManagerListener, e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, ArrayList<SNHeader> headers, String result) {
                callBackError(asyncManagerListener);
            }
        });

    }
}
