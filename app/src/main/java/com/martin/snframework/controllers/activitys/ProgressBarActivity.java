package com.martin.snframework.controllers.activitys;

import android.os.Bundle;

import com.martin.snframework.R;
import com.sn.annotation.SNInjectElement;
import com.sn.interfaces.SNThreadDelayedListener;
import com.sn.main.SNElement;

/**
 * Created by xuhui on 16/5/25.
 */
public class ProgressBarActivity extends BaseActivity {

    @SNInjectElement(id = R.id.pbStyle1)
    SNElement pbStyle1;
    @SNInjectElement(id = R.id.ivAvatar)
    SNElement ivAvatar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        $.contentView(R.layout.activity_progress_bar);

        $.util.threadDelayed(1000, new SNThreadDelayedListener() {
            @Override
            public void onFinish() {
                pbStyle1.progress(100);
            }
        });


        //ivAvatar.image($.readBitMap(R.drawable.avatar));

        // ivAvatar.image("http://f.hiphotos.baidu.com/image/h%3D200/sign=f3f6ab70cc134954611eef64664f92dd/dcc451da81cb39db1bd474a7d7160924ab18302e.jpg", R.drawable.avatar_def);

    }


}
