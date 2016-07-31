package com.example.tllano.avtivity.uiactivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class FrameAnimationActivity extends BaseActivity {
    private ImageView frameAnimation;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        frameAnimation = (ImageView) findViewById(R.id.frame_animation_01);
        // 设置背景样式
        frameAnimation.setBackgroundResource(R.drawable.drawable_anim);
        anim = (AnimationDrawable) frameAnimation.getBackground();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            // 先stop 然后 start
            anim.stop();
            anim.start();
            return  true;
        }
        return super.onTouchEvent(event);
    }
}
