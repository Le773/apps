package com.example.tllano.avtivity.uiactivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class AnimatorActivity extends BaseActivity implements View.OnClickListener{
    private Button button, translateStart, translateEnd, scaleStart, scaleEnd, alphaStart, alphaEnd, rotateStart, rotateEnd;
    private ImageView scanLight;

    View viewToAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_animator);

        button = (Button) findViewById(R.id.toggleButton_01);
        viewToAnimate = findViewById(R.id.view_prop_animator_01);
        translateStart = (Button)findViewById(R.id.translateStart);
        translateEnd = (Button)findViewById(R.id.translateEnd);
        scaleStart = (Button)findViewById(R.id.scaleStart);
        scaleEnd = (Button)findViewById(R.id.scaleEnd);
        alphaStart = (Button)findViewById(R.id.alphaStart);
        alphaEnd = (Button)findViewById(R.id.alphaEnd);
        rotateStart = (Button)findViewById(R.id.rotateStart);
        rotateEnd = (Button)findViewById(R.id.rotateEnd);
        scanLight = (ImageView) findViewById(R.id.prop_animator_imgview_01);

        translateStart.setOnClickListener(this);
        translateEnd.setOnClickListener(this);
        scaleStart.setOnClickListener(this);
        scaleEnd.setOnClickListener(this);
        alphaStart.setOnClickListener(this);
        alphaEnd.setOnClickListener(this);
        rotateStart.setOnClickListener(this);
        rotateEnd.setOnClickListener(this);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.toggleButton_01:
                if(viewToAnimate.getAlpha() > 0f) {
                    // 如果视图已经可见，将其从右侧滑出
                    Toast.makeText(AnimatorActivity.this, "view visible", Toast.LENGTH_SHORT).show();
                    viewToAnimate.animate().alpha(0f).translationX(1000f);
                } else {
                    // 如果视图隐藏，原地做渐显动画
                    viewToAnimate.setTranslationX(0f);
                    viewToAnimate.animate().alpha(1f);
                }
                break;
            // 平移 setFillAfter(true) 控制执行动画后定在当前状态
            case R.id.translateStart:
                Animation translateIn = new TranslateAnimation(0, 100, 0, 0);
                // 设置持续时间
                translateIn.setDuration(500);
                
                // 设置动画停留在最后一帧
                /*
                  ****动画结束时，停留在最后一帧*********
                 setFillAfter(true);
                 setFillBefore(false);


                 //*****动画结束时，停留在第一帧*********
                 setFillAfter(false);
                 setFillBefore(true);  */

                translateIn.setFillAfter(true);
                scanLight.startAnimation(translateIn);
                break;

            case R.id.translateEnd:
                Animation translateOut = new TranslateAnimation(100, 0, 0, 0);
                translateOut.setDuration(500);
                translateOut.setFillAfter(true);
                scanLight.startAnimation(translateOut);
                break;

            //缩放  后四个参数控制沿自身中心点缩放
            case R.id.scaleStart:
                Animation sIn = new ScaleAnimation(1f, 2f, 1f, 2f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sIn.setDuration(500);
                sIn.setFillAfter(true);
                scanLight.startAnimation(sIn);
                break;
            case R.id.scaleEnd:
                Animation sOut = new ScaleAnimation(2f, 1f, 2f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                sOut.setDuration(500);
                sOut.setFillAfter(true);
                scanLight.startAnimation(sOut);
                break;
            //透明度
            case R.id.alphaStart:
                Animation aIn = new AlphaAnimation(1f, 0f);
                aIn.setDuration(500);
                aIn.setFillAfter(true);
                scanLight.startAnimation(aIn);
                break;
            case R.id.alphaEnd:
                Animation aOut = new AlphaAnimation(0f, 1f);
                aOut.setDuration(500);
                aOut.setFillAfter(true);
                scanLight.startAnimation(aOut);
                break;
            //旋转  后四个参数控制沿自身中心点旋转
            case R.id.rotateStart:
                Animation rIn = new RotateAnimation(0f, +360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rIn.setDuration(500);
                rIn.setFillAfter(true);
                scanLight.startAnimation(rIn);
                break;
            case R.id.rotateEnd:
                Animation rOut = new RotateAnimation(+360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rOut.setDuration(500);
                rOut.setFillAfter(true);
                scanLight.startAnimation(rOut);
                break;
            default:
                break;

        }

    }
}
