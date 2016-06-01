package com.martin.snframework.cores;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.sn.interfaces.SNOnClickListener;
import com.sn.interfaces.SNOnTouchListener;
import com.sn.main.SNElement;

import java.util.EventListener;
import java.util.IllegalFormatCodePointException;

/**
 * Created by xuhui on 16/5/26.
 */
public class ImageAttacher {
    SNElement $img;
    ImageView img;

    public ImageAttacher(SNElement element) {
        $img = element;
        img = $img.toView(ImageView.class);
        init();
    }

    private static final int STATE_NORMAL = 0;
    private static final int STATE_ZOOM = 1;
    int state = STATE_NORMAL;

    void init() {
        $img.click(new SNOnClickListener() {
            @Override
            public void onClick(SNElement view) {

            }
        });
        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == MotionEvent.ACTION_POINTER_2_DOWN) {
                    //第二个手指按下
                    state = STATE_ZOOM;
                    $img.util.logInfo(ImageAttacher.class, "第二个手指按下");
                }
                if (action == MotionEvent.ACTION_POINTER_2_UP) {
                    state = STATE_NORMAL;
                    $img.util.logInfo(ImageAttacher.class, "第二个手指松开");
                }
                if (action == MotionEvent.ACTION_MOVE) {
                    if (state == STATE_ZOOM) {
                        if (event.getPointerCount() == 2) {
                            MotionEvent.PointerCoords coords_one = new MotionEvent.PointerCoords();
                            event.getPointerCoords(0, coords_one);
                            MotionEvent.PointerCoords coords_two = new MotionEvent.PointerCoords();
                            event.getPointerCoords(1, coords_two);

                            $img.height($img.height() + 1);
                            $img.width($img.width() + 1);
                            $img.util.logInfo(ImageAttacher.class, $img.height() + "==" + $img.width());
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    /**
     * 根据两点间经纬度坐标（double值），计算两点间距离，
     */
    public static double distanceOfTwoPoints(double x1, double y1,
                                             double x2, double y2) {
        double _x = Math.abs(x1 - x2);
        double _y = Math.abs(y1 - y2);
        return Math.sqrt(_x * _x + _y * _y);
    }
}
