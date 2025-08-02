package org.cocos2dx.javascript;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.widget.AppCompatImageView;

public class DragFloatActionButton extends AppCompatImageView {
    private int downX = 0;
    private int downY = 0;
    private int lastX;
    private int lastY;
    private OnClickListener onClickListener;
    private ViewGroup parent;
    private int parentHeight;
    private int parentWidth;
    private int upX = 0;
    private int upY = 0;

    public interface OnClickListener {
        void onClick();
    }

    public DragFloatActionButton(Context context) {
        super(context);
    }

    private void moveHide(int i10) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnClickListener onClickListener2;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            ViewParent parent2 = getParent();
            this.lastX = rawX;
            this.downX = rawX;
            this.lastY = rawY;
            this.downY = rawY;
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
                ViewGroup viewGroup = (ViewGroup) parent2;
                this.parent = viewGroup;
                this.parentHeight = viewGroup.getHeight();
                this.parentWidth = this.parent.getWidth();
            }
        } else if (action == 1) {
            this.upX = (int) motionEvent.getRawX();
            this.upY = (int) motionEvent.getRawY();
            if (Math.max(Math.abs(Math.abs(this.upX) - Math.abs(this.downX)), Math.abs(Math.abs(this.upY) - Math.abs(this.downY))) <= 10 && (onClickListener2 = this.onClickListener) != null) {
                onClickListener2.onClick();
            }
            moveHide(rawX);
        } else if (action == 2) {
            float x10 = getX() + ((float) (rawX - this.lastX));
            float y10 = getY() + ((float) (rawY - this.lastY));
            if (x10 < 0.0f) {
                x10 = 0.0f;
            } else if (x10 > ((float) (this.parentWidth - getWidth()))) {
                x10 = (float) (this.parentWidth - getWidth());
            }
            if (y10 < 0.0f) {
                y10 = 0.0f;
            } else if (y10 > ((float) (this.parentHeight - getHeight()))) {
                y10 = (float) (this.parentHeight - getHeight());
            }
            setX(x10);
            setY(y10);
            this.lastX = rawX;
            this.lastY = rawY;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener2) {
        this.onClickListener = onClickListener2;
    }

    public DragFloatActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DragFloatActionButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
