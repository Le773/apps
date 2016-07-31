package com.example.tllano.avtivity.uiactivity;


import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import com.example.tllano.avtivity.R;
import com.example.tllano.avtivity.activity.BaseActivity;

public class FlipperActivity extends BaseActivity {
    private boolean mIsHeads;
//    private ObjectAnimator mFlipper;
    private AnimatorSet mFlipper;
    private Bitmap mHeadsImage, mTailsImage;
    private ImageView mFlipImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flipper);

        mHeadsImage = BitmapFactory.decodeResource(getResources(), R.drawable.apple_pic);
        mTailsImage = BitmapFactory.decodeResource(getResources(), R.drawable.banana_pic);

        mFlipImage = (ImageView) findViewById(R.id.flip_image);
//        mFlipImage.setImageBitmap(mHeadsImage);
        mFlipImage.setImageResource(R.drawable.apple_pic);
        mIsHeads = true;

        // 设置y轴旋转
        /*
        mFlipper = ObjectAnimator.ofFloat(mFlipImage, "translationY  ", 0f, 360f);
        mFlipper.setDuration(500);
        */

        // 根据xml加载AnimatorSet
        mFlipper = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.flip);
        // 将动画附加到适当的目标试图
        mFlipper.setTarget(mFlipImage);
        ObjectAnimator flipAnimator = (ObjectAnimator) mFlipper.getChildAnimations().get(0);

//        mFlipper.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        flipAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if(animation.getAnimatedFraction() >= 0.25f && mIsHeads) {
                    mFlipImage.setImageBitmap(mTailsImage);
                    mIsHeads = false;
                }

                if(animation.getAnimatedFraction() >= 0.75f && !mIsHeads) {
                    mFlipImage.setImageBitmap(mHeadsImage);
                    mIsHeads = true;
                }
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            mFlipper.start();
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
