package org.cocos2dx.javascript;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class WeltLinearLayout extends LinearLayout {
    private GestureDetector gestureDetector;
    private float hig;
    /* access modifiers changed from: private */
    public boolean isDragging = false;
    private int lastX;
    private int lastY;
    private Context mContext;
    private int screenHeight;
    private int screenWidth;

    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            if (WeltLinearLayout.this.isDragging) {
                return false;
            }
            WeltLinearLayout.this.performClick();
            return true;
        }
    }

    public WeltLinearLayout(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init() {
        getResources().getDisplayMetrics();
        this.screenWidth = DeviceUtils.getScreenWidth(this.mContext);
        this.screenHeight = DeviceUtils.getScreenHeight(this.mContext);
        this.gestureDetector = new GestureDetector(getContext(), new a());
        float dp2px = (float) DeviceUtils.dp2px(this.mContext, 35.0f);
        this.hig = dp2px;
        setY(dp2px);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.screenWidth = DeviceUtils.getScreenWidth(this.mContext);
        this.screenHeight = DeviceUtils.getScreenHeight(this.mContext) - 150;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.lastX = (int) motionEvent.getRawX();
            this.lastY = (int) motionEvent.getRawY();
            this.isDragging = false;
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX() - ((float) this.lastX);
                float rawY = motionEvent.getRawY() - ((float) this.lastY);
                if ((rawX * rawX) + (rawY * rawY) > 100.0f) {
                    this.isDragging = true;
                    setX(getX() + rawX);
                    setY(getY() + rawY);
                    this.lastX = (int) motionEvent.getRawX();
                    this.lastY = (int) motionEvent.getRawY();
                }
            }
        } else if (!this.isDragging) {
            performClick();
        }
        return true;
    }

    public WeltLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    public WeltLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mContext = context;
        init();
    }
}
