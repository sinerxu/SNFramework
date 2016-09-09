package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.martin.snframework.controllers.injects.UserViewInject;
import com.sn.annotation.SNInjectElement;
import com.sn.core.SNPullRefreshManager;
import com.sn.core.SNRefreshManager;
import com.sn.interfaces.SNAdapterOnItemClickListener;
import com.sn.interfaces.SNOnHttpResultListener;
import com.sn.interfaces.SNPullRefreshManagerListener;
import com.sn.interfaces.SNThreadDelayedListener;
import com.sn.main.SNElement;
import com.sn.models.SNAdapterViewInject;
import com.sn.models.SNHeader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xuhui on 16/7/5.
 */
public class MingToolsActivity extends BaseActivity {

    @SNInjectElement(id = R.id.gvTest)
    SNElement gvTest;
    @SNInjectElement(id = R.id.svMain)
    SNElement svMain;
    SNRefreshManager<String> pullRefreshManager;
    List<String> actions;

    @Override
    public void onInitNavBar() {
        super.onInitNavBar();
        showNavBar();
        navTitleBar.showNavTitle("算命工具");
        navTitleBar.showNavBack();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initList();
    }

    @Override
    public int onLayout() {
        return R.layout.activity_ming_tools;
    }

    void initList() {
        actions = new ArrayList<String>();
        actions.add("姓名配对");
        actions.add("八字合婚");


        SNPullRefreshManager.create(svMain, new SNPullRefreshManagerListener() {
            @Override
            public void onRefresh(SNRefreshManager manager) {
                $.util.threadDelayed(1000, new SNThreadDelayedListener() {
                    @Override
                    public void onFinish() {
                        pullRefreshManager.setData(actions);
                        pullRefreshManager.success();
                    }
                });
            }

            @Override
            public void onLoadMore(SNRefreshManager manager) {

            }

            @Override
            public void onCreate(SNRefreshManager manager) {
                pullRefreshManager = manager;
                manager.setData(actions);
                gvTest.bindListAdapter(manager, R.layout.adapter_user, UserViewInject.class);
                gvTest.itemClick(new SNAdapterOnItemClickListener() {
                    @Override
                    public void onItemClick(SNAdapterViewInject holder) {
                        if (holder.getPos() == 0) {
                            HashMap<String, String> bodys = new HashMap<String, String>();
                            try {
                                bodys.put("xm1", "张三");
                                bodys.put("xm2", "李四");
                                bodys.put("do", "yes");
                                $.post("http://tools.2345.com/peidui/xingming", bodys, "GB2312", "GB2312", new SNOnHttpResultListener() {
                                    @Override
                                    public void onSuccess(int statusCode, ArrayList<SNHeader> headers, String result) {
                                        $.util.logInfo(PullToRefreshActivity.class, result);
                                        $.toast(result, 2000);
                                    }

                                    @Override
                                    public void onFailure(int statusCode, ArrayList<SNHeader> headers, String result) {
                                        $.toast("error:" + result, 2000);
                                    }
                                });
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        if (holder.getPos() == 1) {
                            HashMap<String, String> requestHeader = new HashMap<String, String>();
                            requestHeader.put("Cookie", "PHPSESSID=7vjhqi2o2f937ra1a6mp5vkcj5; bz_name=" + $.util.urlEncode("张张") + "; bz_name2=" + $.util.urlEncode("丽丽") + "; bz_year2=2001; bz_year=2006; bz_month2=1; bz_month=2; bz_day2=4; bz_day=1; bz_hour2=3; bz_hour=3; Hm_lvt_6ab7a391c8d69b4f62b7c54b2d70919c=1467625047,1467625076,1467680325; Hm_lpvt_6ab7a391c8d69b4f62b7c54b2d70919c=1467687388; _ga=GA1.2.106105089.1467625046; Hm_lvt_ddb0f66975e8fb16abad7ba3ff987058=1467625046,1467625076,1467680325; Hm_lpvt_ddb0f66975e8fb16abad7ba3ff987058=1467687389");
                            $.get("http://tools.2345.com/suanming/bzpd.htm", requestHeader, "GB2312", new SNOnHttpResultListener() {
                                @Override
                                public void onSuccess(int statusCode, ArrayList<SNHeader> headers, String result) {
                                    $.util.logInfo(PullToRefreshActivity.class, result);
                                    Document document = Jsoup.parse(result);
                                    Elements elements = document.getElementsByClass("box_con");
                                    Element element = elements.get(0);
                                    element.getElementsByClass("cur_info").remove();

                                    String content = element.html();
                                    toast(content);

//                                    String bazi_nan = elements.get(0).getElementsByTag("tr").get(2).getElementsByTag("td").get(1).html();
//                                    String bazi_nv = elements.get(0).getElementsByTag("tr").get(2).getElementsByTag("td").get(3).html();
//                                    String nanming = document.getElementsByClass("peidui_result_dl").get(0).getElementsByTag("h4").text();
//                                    String nvming = document.getElementsByClass("peidui_result_dl").get(1).getElementsByTag("h4").text();


                                }

                                @Override
                                public void onFailure(int statusCode, ArrayList<SNHeader> headers, String result) {
                                    $.toast("error:" + result, 2000);
                                }
                            });
                        }
                    }
                });
            }
        });
    }
}
